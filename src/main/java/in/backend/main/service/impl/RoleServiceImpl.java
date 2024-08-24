package in.backend.main.service.impl;

import in.backend.main.dto.request.RoleRequest;
import in.backend.main.dto.response.ApiResponse;
import in.backend.main.dto.response.RoleResponse;
import in.backend.main.enity.Role;
import in.backend.main.exception.ErrorCode;
import in.backend.main.mapper.IRoleMapper;
import in.backend.main.repository.IPermissionRepository;
import in.backend.main.repository.IRoleRepository;
import in.backend.main.service.IRoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@PreAuthorize("hasRole('ADMIN')")
public class RoleServiceImpl implements IRoleService {

    IRoleRepository roleRepository;
    IPermissionRepository permissionRepository;
    IRoleMapper roleMapper;

    @Override
    public ApiResponse<?> create(RoleRequest roleRequest) {

        if (roleRepository.existsByName(roleRequest.getName())){
            return ApiResponse.<String>builder()
                    .code(ErrorCode.USER_NOT_FOUND.getHttpStatus().value())
                    .result("")
                    .build();
        }

        for (String per : roleRequest.getPermissions()) {
            if (!permissionRepository.existsByName(per)) {
                return ApiResponse.<String>builder()
                        .code(ErrorCode.USER_NOT_FOUND.getHttpStatus().value())
                        .result("")
                        .build();
            }
        }

        Role role = roleMapper.toRole(roleRequest);
        role = roleRepository.save(role);

        return ApiResponse.<RoleResponse>builder()
                .code(HttpStatus.CREATED.value())
                .result(roleMapper.toRoleResponse(role))
                .build();
    }

    @Override
    public List<RoleResponse> getAll() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    @Override
    public String delete(String id) {
        roleRepository.deleteById(id);
        return "Role deleted successfully";
    }
}
