package in.backend.main.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import in.backend.main.utility.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = Constants.USER_TABLE)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.USER_ID)
    private Long id;

    @NotNull(message = "UserName not Null")
    @Column(unique = true, name = Constants.USER_NAME, length = Constants.S_SHORT_NAME)
    private String userName;

    @NotNull(message = "Password not Null")
    @Column(name = Constants.PASSWORD)
    private String password;

    @Column(name = Constants.FULL_NAME, length = Constants.S_LONG_NAME)
    private String fullName;

    @NotNull
    @Column(name = Constants.EMAIL, length = Constants.S_LONG_NAME, unique = true)
    private String email;

    @CreatedDate
    @Column(name = Constants.CREATE_AT)
    private Timestamp created_at;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = Constants.PROFILE_ID, referencedColumnName = Constants.PROFILE_ID)
//    private UserProfiles userProfiles;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = Constants.USER_ROLES_TABLE,
            joinColumns = @JoinColumn(name = Constants.USER_ID),
            inverseJoinColumns = @JoinColumn(name = Constants.ROLES_ID)
    )
    private Set<Roles> roles = new HashSet<>();
}
