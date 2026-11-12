package com.ecommerce.springBoot.product.application.commands;

import java.math.BigDecimal;

public record CreateProductCommand(
        String name,
        BigDecimal price,
        Integer stock
) {}
