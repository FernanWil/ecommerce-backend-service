package com.ecommerce.springBoot.application.port.out;

import com.ecommerce.springBoot.domain.model.Product;

public interface ProductRepositoryPort {
    Product save(Product product);
}
