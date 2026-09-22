package com.ecommerce.springBoot.application.ports.out.Product;

import com.ecommerce.springBoot.domain.models.Product;

import java.util.Optional;

public interface ProductRepositoryPort {
    Product save(Product product);
    Optional<Product> findById(String productId); // Hacer function
}
