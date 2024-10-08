package in.backend.main.mapper;

import in.backend.main.dto.request.UserCreationRequest;
import in.backend.main.dto.request.UserUpdateRequest;
import in.backend.main.dto.response.UserResponse;
import in.backend.main.enity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(UserUpdateRequest request,@MappingTarget User user);
}
