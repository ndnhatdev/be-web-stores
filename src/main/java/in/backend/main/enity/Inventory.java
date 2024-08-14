package in.backend.main.enity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    Integer quantity;
    LocalDateTime lastUpdate;

    @OneToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "product_id")
    Products products;
}
