package com.ecommerce.springBoot.domain.model;
import java.math.BigDecimal;
import java.util.UUID;

public record Product(
        String id,
        String name,
        BigDecimal price,
        Integer stock) {

    public static Product createNew(String name, BigDecimal price, Integer stock){
        return  new Product(
                UUID.randomUUID().toString(),
                name,
                price,
                stock
        );
    }
}

