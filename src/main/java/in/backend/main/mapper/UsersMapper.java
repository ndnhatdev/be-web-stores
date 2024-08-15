package in.backend.main.mapper;

import in.backend.main.dto.UsersDTO;
import in.backend.main.entity.Users;

public interface UsersMapper {
    public UsersDTO convertToDTO (Users users);
    public Users convertToEntity (UsersDTO usersDTO);
}
