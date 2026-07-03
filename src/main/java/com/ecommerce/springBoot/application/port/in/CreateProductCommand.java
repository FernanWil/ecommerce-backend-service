package com.ecommerce.springBoot.application.port.in;

import java.math.BigDecimal;

public record CreateProductCommand(
        String name,
        BigDecimal price,
        Integer stock
) {
}
