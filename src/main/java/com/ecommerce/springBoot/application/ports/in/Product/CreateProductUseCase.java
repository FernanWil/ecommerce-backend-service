package com.ecommerce.springBoot.application.ports.in.Product;

import com.ecommerce.springBoot.application.dto.Product.CreateProductCommand;
import com.ecommerce.springBoot.domain.models.Product;

public interface CreateProductUseCase {
    Product execute(CreateProductCommand command);
}
