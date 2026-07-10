package com.ecommerce.springBoot.application.ports.in.Order;

import com.ecommerce.springBoot.application.dto.Order.CreateOrderCommand;
import com.ecommerce.springBoot.domain.models.Order;

public interface CreateOrderUseCase {
    Order execute(CreateOrderCommand command);
}
