package com.ecommerce.springBoot.order.adapters.in.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderLineDto(
        String productId,
        @NotNull(message = "Quantity cannot be null")
        @Positive(message = "Quantity must be greater than 0")
        Integer quantity
) {
}
