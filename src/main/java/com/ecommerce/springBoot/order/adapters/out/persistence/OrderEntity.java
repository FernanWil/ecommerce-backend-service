package com.ecommerce.springBoot.order.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "user_id")
    private String userId;
    private String status;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLineEntity> orderLine;

}
