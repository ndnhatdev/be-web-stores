package in.backend.main.enity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(nullable = false)
    String name;
    String description;
    Integer quantity;
    @Column(name = "create_at")
    LocalDateTime createAt;

    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "category_id")
    Categories categories;

    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "supplier_id")
    Suppliers suppliers;

    @OneToMany(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderDetails> orderDetails;

    @OneToOne(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    Inventory inventory;
}
