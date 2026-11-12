package com.ecommerce.springBoot.order.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderLine (
        String orderLineId,
        String productId,
        Integer quantity,
        BigDecimal unitPrice
) {

    public BigDecimal calculateSubtotal() {
        BigDecimal quantity = BigDecimal.valueOf(this.quantity);
        return this.unitPrice.multiply(quantity);
    }

    public static OrderLine createNew(String productId, Integer quantity, BigDecimal unitPrice){
        return new OrderLine(
                UUID.randomUUID().toString(),
                productId,
                quantity,
                unitPrice
        );
    }
}
