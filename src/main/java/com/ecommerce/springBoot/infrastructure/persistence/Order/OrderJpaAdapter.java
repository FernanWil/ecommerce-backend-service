package com.ecommerce.springBoot.infrastructure.persistence.Order;

import com.ecommerce.springBoot.application.ports.out.Order.OrderRepositoryPort;
import com.ecommerce.springBoot.application.ports.out.Product.ProductRepositoryPort;
import com.ecommerce.springBoot.domain.models.Order;
import com.ecommerce.springBoot.domain.models.OrderLine;
import com.ecommerce.springBoot.infrastructure.persistence.JpaRepository.Order.OrderJpaRespositoryInterface;
import com.ecommerce.springBoot.infrastructure.persistence.Order.OrderLine.OrderLineEntity;
import com.ecommerce.springBoot.infrastructure.persistence.Product.ProductEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
            String productId = item.productId();
            Integer quantity = item.quantity();
            BigDecimal price = item.price();
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
            BigDecimal price = item.price();
            return new OrderLine(idOrderLine,productId,quantity,price);
        }).toList();
    }

//    public List<OrderLineEntity> getOrderLineEntity(Order order, OrderEntity orderEntity){
//        return order.lines().stream().map(item -> {
//            String idOrderLine = item.orderLineId();
//            String productId = item.productId();
//            Integer quantity = item.quantity();
//            BigDecimal price = item.price();
//            return new OrderLineEntity(idOrderLine,orderEntity,,quantity,price);
//        }).toList();
//    }


}
