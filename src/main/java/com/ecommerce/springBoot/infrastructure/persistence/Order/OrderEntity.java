package com.ecommerce.springBoot.infrastructure.persistence.Order;

import com.ecommerce.springBoot.infrastructure.persistence.Order.OrderLine.OrderLineEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
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
