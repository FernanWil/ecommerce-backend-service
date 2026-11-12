package com.ecommerce.springBoot.order.adapters.out.persistence;

import com.ecommerce.springBoot.product.adapters.out.persistence.ProductEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_line")
public class OrderLineEntity {
    @Id
    @Column(name = "order_line_id")
    String orderLineId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product")
    private ProductEntity product;

    Integer quantity;

    @Column(name = "price_at_purchase")
    BigDecimal priceAtPurchase;
}
