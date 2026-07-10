package com.ecommerce.springBoot.application.dto.Order;

import com.ecommerce.springBoot.domain.models.Product;
import java.util.List;

public record CreateOrderCommand(
        String userId,
        List<Product> items
) {
    public CreateOrderCommand{
        if(userId == null) throw new IllegalArgumentException("User must not be null");
        if (items == null || items.isEmpty()) System.out.println("Items can't be null ");
    }
}
