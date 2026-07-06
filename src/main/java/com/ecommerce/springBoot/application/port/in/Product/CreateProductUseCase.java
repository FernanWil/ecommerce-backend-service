package com.ecommerce.springBoot.application.port.in.Product;

import com.ecommerce.springBoot.application.dto.CreateProductCommand;
import com.ecommerce.springBoot.domain.model.Product;

public interface CreateProductUseCase {
    Product execute(CreateProductCommand command);
}
