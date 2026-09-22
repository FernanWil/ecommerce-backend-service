package com.ecommerce.springBoot.application.dto.Order;

import java.util.List;

public record CreateOrderCommand(
        String userId,
        List<OrderLineCommand> items
) {
    public CreateOrderCommand{
        if(userId == null) throw new IllegalArgumentException("User must not be null");
        if (items == null || items.isEmpty()) throw new IllegalArgumentException("Items can't be null ");
//        for(OrderLine item: items) {
//            if (item..compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Price must be greater than 0");
//        }
    }
}
