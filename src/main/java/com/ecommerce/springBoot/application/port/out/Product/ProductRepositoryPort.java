package com.ecommerce.springBoot.application.port.out.Product;

import com.ecommerce.springBoot.domain.model.Product;

public interface ProductRepositoryPort {
    Product save(Product product);
}
