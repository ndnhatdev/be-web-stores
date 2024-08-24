package in.backend.main.service.impl;

import in.backend.main.dto.request.PermissionRequest;
import in.backend.main.dto.response.ApiResponse;
import in.backend.main.dto.response.PermissionResponse;
import in.backend.main.enity.Permission;
import in.backend.main.mapper.IPermissionMapper;
import in.backend.main.repository.IPermissionRepository;
import in.backend.main.service.IPermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@PreAuthorize("hasRole('ADMIN')")
public class PermissionServiceImpl implements IPermissionService {

    IPermissionRepository permissionRepository;
    IPermissionMapper permissionMapper;

    @Override
    public List<PermissionResponse> getAllPermissions() {
        return permissionRepository.findAll().stream().map(permissionMapper::toPermissionResponse).toList();
    }

    @Override
    public ApiResponse<?> createPermission(PermissionRequest request) {

        if (permissionRepository.existsByName(request.getName())) {
            return ApiResponse.<String>builder()
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .result("")
                    .build();
        }

        var permission = permissionMapper.toPermission(request);

        return ApiResponse.<PermissionResponse>builder()
                .code(HttpStatus.CREATED.value())
                .result(permissionMapper.toPermissionResponse(permissionRepository.save(permission)))
                .build();
    }

    @Override
    public ApiResponse<?> deletePermission(String name) {
        if (!permissionRepository.existsByName(name)) {
            return ApiResponse.<String>builder()
                    .code(HttpStatus.NOT_FOUND.value())
                    .result("")
                    .build();
        }
        Permission permission = permissionRepository.findByName(name).orElseThrow();
        permissionRepository.delete(permission);
        return ApiResponse.<String>builder()
                .code(HttpStatus.NO_CONTENT.value())
                .result("")
                .build();
    }
}
