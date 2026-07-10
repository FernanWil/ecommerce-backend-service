package com.ecommerce.springBoot.application.ports.out.Product;

import com.ecommerce.springBoot.domain.models.Product;

public interface ProductRepositoryPort {
    Product save(Product product);
}
