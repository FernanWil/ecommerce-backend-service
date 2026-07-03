package com.ecommerce.springBoot.application.port.in;

public interface CreateProductUseCase {
    void execute(CreateProductCommand command);
}
