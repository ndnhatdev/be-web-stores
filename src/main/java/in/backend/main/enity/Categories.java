package in.backend.main.enity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "categorties")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(nullable = false)
    String name;

    String description;

    @OneToMany(mappedBy = "categories", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    List<Products> products;
}
