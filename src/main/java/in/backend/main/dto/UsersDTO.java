package in.backend.main.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
    private Long id;
    private String userName;
    private String fullName;
    @Email(message = "wrong email template")
    private String email;
    private Set<RolesDTO> rolesDTO;
//    private ProfileDTO profileDTO;
}
