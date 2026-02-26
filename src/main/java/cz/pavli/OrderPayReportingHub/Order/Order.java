package cz.pavli.OrderPayReportingHub.Order;

import cz.pavli.OrderPayReportingHub.Product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(length = 4000)
    private String description;

    @Column(nullable = false)
    private Instant createdAt;

    private Instant updatedAt;
    private Instant completedAt;
}