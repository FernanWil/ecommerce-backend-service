package com.ecommerce.springBoot.domain.model;

public record User(
        Integer id,
        String name,
        String email,
        String password
) {
}
