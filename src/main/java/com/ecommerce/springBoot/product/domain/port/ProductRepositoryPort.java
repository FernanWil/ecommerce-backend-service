package com.ecommerce.springBoot.product.domain.port;

import com.ecommerce.springBoot.product.domain.model.Product;

import java.util.Optional;

public interface ProductRepositoryPort {
    Product save(Product product);
    Optional<Product> findById(String productId); // Hacer function
}
