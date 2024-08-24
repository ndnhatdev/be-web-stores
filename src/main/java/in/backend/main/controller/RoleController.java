package in.backend.main.controller;

import in.backend.main.dto.request.RoleRequest;
import in.backend.main.dto.response.ApiResponse;
import in.backend.main.dto.response.RoleResponse;
import in.backend.main.service.IRoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {
    IRoleService roleService;

    @GetMapping
    ApiResponse<List<RoleResponse>> getAllRole() {
        return ApiResponse.<List<RoleResponse>>builder()
                .code(HttpStatus.OK.value())
                .result(roleService.getAll())
                .build();
    }

    @PostMapping
    ApiResponse<?> createRole(@RequestBody RoleRequest roleRequest) {
        return roleService.create(roleRequest);
    }

    @DeleteMapping("/{id}")
    ApiResponse<String> deleteRole(@PathVariable String id) {
        return ApiResponse.<String>builder()
                .code(HttpStatus.NO_CONTENT.value())
                .result(roleService.delete(id))
                .build();
    }
}
