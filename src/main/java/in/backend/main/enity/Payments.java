package in.backend.main.enity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "payments")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    LocalDateTime paymentDate;
    Integer amount;
    String method;

    @OneToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "order_id")
    Orders orders;
}
