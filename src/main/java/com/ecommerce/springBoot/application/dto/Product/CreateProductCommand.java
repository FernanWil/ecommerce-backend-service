package com.ecommerce.springBoot.application.dto.Product;

import java.math.BigDecimal;

public record CreateProductCommand(
        String name,
        BigDecimal price,
        Integer stock
) {}
