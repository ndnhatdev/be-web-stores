package in.backend.main.controller;

import in.backend.main.dto.request.PermissionRequest;
import in.backend.main.dto.response.ApiResponse;
import in.backend.main.dto.response.PermissionResponse;
import in.backend.main.service.IPermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionController {
    IPermissionService permissionService;

    @GetMapping
    public ApiResponse<List<PermissionResponse>> getAllPermission() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .code(HttpStatus.OK.value())
                .result(permissionService.getAllPermissions())
                .build();
    }

    @PostMapping
    public ApiResponse<?> createPermission(@RequestBody PermissionRequest permissionRequest) {
        return permissionService.createPermission(permissionRequest);
    }

    @DeleteMapping("{name}")
    public ApiResponse<?> deletePermission(@PathVariable String name) {
        return permissionService.deletePermission(name);
    }
}
