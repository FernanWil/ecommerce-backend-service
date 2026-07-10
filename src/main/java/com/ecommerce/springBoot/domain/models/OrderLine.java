package com.ecommerce.springBoot.domain.models;

import java.math.BigDecimal;

public record OrderLine (
        String Id,
        String productId,
        Integer quantity,
        BigDecimal price
) {

    public BigDecimal calculateSubtotal() {
        BigDecimal newStock = BigDecimal.valueOf(this.quantity);
        return this.price.multiply(newStock);
    }
}
