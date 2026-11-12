package com.ecommerce.springBoot.order.domain.port;

import com.ecommerce.springBoot.order.domain.model.Order;

public interface OrderRepositoryPort {
    Order saveOrder(Order order);
}
