package com.ecommerce.springBoot.infrastructure.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderLineDto(
        String productId,
        @NotNull(message = "Price cannot be null")
        @Positive(message = "Price must be greater than 0")
        Integer quantity
) {
}
