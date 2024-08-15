package in.backend.main.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRepository {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String username;
    private String name;
    private Collection<? extends GrantedAuthority> roles;

    public JwtRepository(String jwt, Long id, String username, String fullName, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.token = jwt;
        this.username = username;
        this.name = fullName;
        this.roles = authorities;
    }
}
