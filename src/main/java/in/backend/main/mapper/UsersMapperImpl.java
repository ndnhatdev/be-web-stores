package in.backend.main.mapper;

import in.backend.main.dto.RolesDTO;
import in.backend.main.dto.UsersDTO;
import in.backend.main.entity.Roles;
import in.backend.main.entity.Users;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UsersMapperImpl implements UsersMapper{
    @Override
    public UsersDTO convertToDTO(Users users) {

        UsersDTO usersDTO = new UsersDTO();

        usersDTO.setId(users.getId());
        usersDTO.setUserName(users.getUserName());
        usersDTO.setEmail(users.getEmail());

        RolesDTO rolesDTO = new RolesDTO();
        Set<RolesDTO> rolesDTOS = new HashSet<>();
        for (Roles role : users.getRoles()) {
            rolesDTO.setRoleId(role.getId());
            rolesDTO.setRoleName(role.getName());
            rolesDTOS.add(rolesDTO);
        }
        usersDTO.setRolesDTO(rolesDTOS);
        return usersDTO;
    }

    @Override
    public Users convertToEntity(UsersDTO usersDTO) {

        Users users = new Users();

        users.setId(usersDTO.getId());
        users.setUserName(usersDTO.getUserName());
        users.setEmail(usersDTO.getEmail());

        Roles roles = new Roles();
        Set<Roles> rolesSet = new HashSet<>();
        for (RolesDTO roleDTO : usersDTO.getRolesDTO()) {
            roles.setId(roleDTO.getRoleId());
            roles.setName(roleDTO.getRoleName());
            rolesSet.add(roles);
        }
        users.setRoles(rolesSet);
        return null;
    }
}
