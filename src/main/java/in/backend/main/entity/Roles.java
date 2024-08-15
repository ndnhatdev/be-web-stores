package in.backend.main.entity;

import in.backend.main.utility.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = Constants.ROLES_TABLE)
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.ROLES_ID)
    private Long id;

    @NotNull(message = "Role name not null")
    @Column(name = Constants.ROLE_NAME, length = Constants.S_LONG_NAME, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "roles")
    private Set<Users> users = new HashSet<>();
}
