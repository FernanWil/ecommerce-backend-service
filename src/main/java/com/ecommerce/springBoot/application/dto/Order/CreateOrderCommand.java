package com.ecommerce.springBoot.application.dto.Order;

import com.ecommerce.springBoot.domain.models.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public record CreateOrderCommand(
        String userId,
        List<Product> items
) {
    public CreateOrderCommand{
        if(!Objects.requireNonNull(Boolean.valueOf(userId))) throw new IllegalArgumentException("User must not be null");
        if (items == null || items.isEmpty()) throw new IllegalArgumentException("Items can't be null ");
        for(Product item: items) {
            if (item.price().compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Price must be greater than 0");
        }
    }
}
