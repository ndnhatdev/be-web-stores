package in.backend.main.enity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    LocalDateTime orderDate;
    LocalDateTime deliveryDate;
    String status;
    Integer totalAmount;

    @OneToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "customer_id")
    Customers customers;

    @OneToOne(mappedBy = "orders", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    OrderDetails orderDetails;

    @OneToOne(mappedBy = "orders", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    Payments payments;
}
