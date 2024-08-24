package in.backend.main.service;

import in.backend.main.dto.request.RoleRequest;
import in.backend.main.dto.response.ApiResponse;
import in.backend.main.dto.response.RoleResponse;
import in.backend.main.enity.Role;

import java.util.List;

public interface IRoleService{
    ApiResponse<?> create(RoleRequest roleRequest);
    List<RoleResponse> getAll();
    String delete(String id);
}
