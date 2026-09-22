package com.ecommerce.springBoot.application.dto.Order;

import java.math.BigDecimal;

public record OrderLineCommand(String productId, Integer quantity) {
}
