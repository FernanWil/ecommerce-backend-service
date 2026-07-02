package com.ecommerce.springBoot.domain.model;

public record Product(
        Long id,
        String name,
        Float price,
        Integer stock) {}

