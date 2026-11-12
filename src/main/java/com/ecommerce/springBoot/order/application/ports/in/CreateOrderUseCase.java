package com.ecommerce.springBoot.order.application.ports.in;

import com.ecommerce.springBoot.order.application.commands.CreateOrderCommand;
import com.ecommerce.springBoot.order.domain.model.Order;

public interface CreateOrderUseCase {
    Order execute(CreateOrderCommand command);
}
