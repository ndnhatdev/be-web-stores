package in.backend.main.enity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "permission_tbl")
public class Permission {
    @Id
    String name;
    String description;

    @ManyToMany(mappedBy = "permissions")
    List<Role> roles;
}
