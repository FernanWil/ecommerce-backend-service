package com.ecommerce.springBoot.application.ports.out.Order;

import com.ecommerce.springBoot.domain.models.Order;

public interface OrderRepositoryPort {
    Order saveOrder(Order order);
}
