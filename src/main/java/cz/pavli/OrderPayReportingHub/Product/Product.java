package cz.pavli.OrderPayReportingHub.Product;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String state;

    @Column(length = 4000)
    private String description;

    @Column(nullable = false)
    private Instant createdAt;

    private Instant updatedAt;
    private Instant completedAt;
}