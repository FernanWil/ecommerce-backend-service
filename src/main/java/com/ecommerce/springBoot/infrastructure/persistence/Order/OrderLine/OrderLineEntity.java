package com.ecommerce.springBoot.infrastructure.persistence.Order.OrderLine;

import com.ecommerce.springBoot.domain.models.Order;
import com.ecommerce.springBoot.domain.models.Product;
import com.ecommerce.springBoot.infrastructure.persistence.Order.OrderEntity;
import com.ecommerce.springBoot.infrastructure.persistence.Product.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
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
