package in.backend.main.mapper;

import in.backend.main.dto.request.RoleRequest;
import in.backend.main.dto.response.RoleResponse;
import in.backend.main.enity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IRoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);


}
