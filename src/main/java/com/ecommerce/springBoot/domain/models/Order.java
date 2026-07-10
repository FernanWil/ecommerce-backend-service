package com.ecommerce.springBoot.domain.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record Order(
        String id,
        String userId,
        List<OrderLine> lines,
        BigDecimal totalPrice
) {

    public static Order createNew(String userId, List<OrderLine> lines){
        BigDecimal total = lines.stream().map(OrderLine:: calculateSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        return new Order(
            UUID.randomUUID().toString(),
            userId,
            lines,
            total
        );
    }
}
