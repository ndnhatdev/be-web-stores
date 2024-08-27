package in.backend.main.enity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "invalidate_token")
public class InvalidateToken {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String jit;
    Date expiryTime;
}
