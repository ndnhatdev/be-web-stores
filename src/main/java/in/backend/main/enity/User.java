package in.backend.main.enity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(unique = true, nullable = false)
    String username;
    String password;
    String firstName;
    String lastName;
    @Column(unique = true, nullable = false)
    String email;
    @Column(name = "create_at")
    LocalDateTime createAt;

    @ManyToMany(fetch = FetchType.LAZY)
            @JoinTable(
                    name = "users_role",
                    joinColumns = @JoinColumn(name = "users_id"),
                    inverseJoinColumns = @JoinColumn(name = "roles_id")
            )
    Set<Role> roles;
}
