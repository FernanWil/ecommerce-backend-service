package com.ecommerce.springBoot.product.application.ports.in;

import com.ecommerce.springBoot.product.application.commands.CreateProductCommand;
import com.ecommerce.springBoot.product.domain.model.Product;

public interface CreateProductUseCase {
    Product execute(CreateProductCommand command);
}
