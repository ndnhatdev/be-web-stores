package in.backend.main.enity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String firstName;
    String lastName;
    @Column(nullable = false, unique = true)
    String email;
    String phone;
    String address;
    @Column(name = "create_at")
    LocalDateTime createAt;

    @OneToOne(mappedBy = "customers", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    Orders orders;
}
