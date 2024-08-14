package in.backend.main.enity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    Integer quantity;
    Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "product_id")
    Products products;

    @OneToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "order_id")
    Orders orders;
}
