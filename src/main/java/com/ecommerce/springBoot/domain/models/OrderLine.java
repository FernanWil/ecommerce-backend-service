package com.ecommerce.springBoot.domain.models;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderLine (
        String orderLineId,
        String productId,
        Integer quantity,
        BigDecimal price
) {

    public BigDecimal calculateSubtotal() {
        BigDecimal newStock = BigDecimal.valueOf(this.quantity);
        return this.price.multiply(newStock);
    }

    public static OrderLine createNew(String productId, Integer quantity, BigDecimal price){
        return new OrderLine(
                UUID.randomUUID().toString(),
                productId,
                quantity,
                price
        );
    }
}
