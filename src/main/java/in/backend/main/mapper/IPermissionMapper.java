package in.backend.main.mapper;

import in.backend.main.dto.request.PermissionRequest;
import in.backend.main.dto.response.PermissionResponse;
import in.backend.main.enity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
