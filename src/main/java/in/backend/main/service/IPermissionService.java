package in.backend.main.service;

import in.backend.main.dto.request.PermissionRequest;
import in.backend.main.dto.response.ApiResponse;
import in.backend.main.dto.response.PermissionResponse;
import in.backend.main.enity.Permission;

import java.util.List;
import java.util.Optional;

public interface IPermissionService {
    List<PermissionResponse> getAllPermissions();
    ApiResponse<?> createPermission(PermissionRequest request);
    ApiResponse<?> deletePermission(String name);
}
