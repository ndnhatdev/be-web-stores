package in.backend.main.service;

import in.backend.main.dto.request.UserCreationRequest;
import in.backend.main.dto.request.UserUpdateRequest;
import in.backend.main.dto.response.UserResponse;

import java.util.List;

public interface IUserService{
    List<UserResponse> getAllUsers();
    UserResponse getMyInfo();
    UserResponse getUserById(String id);
    UserResponse createUser(UserCreationRequest request);
    UserResponse updateUser(String id, UserUpdateRequest request);
    String deleteUser(String id);
}
