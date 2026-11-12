package com.ecommerce.springBoot.order.adapters.out.persistence;

import com.ecommerce.springBoot.order.domain.port.OrderRepositoryPort;
import com.ecommerce.springBoot.product.domain.port.ProductRepositoryPort;
import com.ecommerce.springBoot.order.domain.model.Order;
import com.ecommerce.springBoot.order.domain.model.OrderLine;
import com.ecommerce.springBoot.product.adapters.out.persistence.ProductEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class OrderJpaAdapter implements OrderRepositoryPort {
    final OrderJpaRespositoryInterface orderJpaRespositoryInterface;
    final ProductRepositoryPort productRepositoryPort;
    public OrderJpaAdapter (OrderJpaRespositoryInterface orderJpaRespositoryInterface, ProductRepositoryPort productRepositoryPort){
        this.orderJpaRespositoryInterface = orderJpaRespositoryInterface;
        this.productRepositoryPort = productRepositoryPort;
    }
    @Override
    public Order saveOrder(Order order) {
        if (order == null) throw new IllegalArgumentException("Order null");
        List<OrderLine> newListOrderLine = getOrderLine(order);
        LocalDateTime localDateTime = LocalDateTime.now();

        List<OrderLineEntity> orderLineEntities = null;
        OrderEntity orderEntity = new OrderEntity(order.orderId(), order.userId(), "status", order.totalPrice(), localDateTime, orderLineEntities);

        orderLineEntities = order.lines().stream().map(item -> {
            ProductEntity productEntity = new ProductEntity();
            String idOrderLine = item.orderLineId();
            Integer quantity = item.quantity();
            BigDecimal price = item.unitPrice();
            productEntity.setId(item.productId());
            return new OrderLineEntity(idOrderLine, orderEntity, productEntity, quantity, price);
        }).toList();
        orderEntity.setOrderLine(orderLineEntities);
        OrderEntity savedEntity = orderJpaRespositoryInterface.save(orderEntity);
        return new Order(savedEntity.getOrderId(), savedEntity.getUserId(), newListOrderLine, savedEntity.getTotalPrice());
    }

    public List<OrderLine> getOrderLine(Order order){
        return order.lines().stream().map(item -> {
            String idOrderLine = item.orderLineId();
            String productId = item.productId();
            Integer quantity = item.quantity();
            BigDecimal price = item.unitPrice();
            return new OrderLine(idOrderLine,productId,quantity,price);
        }).toList();
    }
}
