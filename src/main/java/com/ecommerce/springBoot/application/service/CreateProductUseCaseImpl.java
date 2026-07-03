package com.ecommerce.springBoot.application.service;

import com.ecommerce.springBoot.application.port.in.CreateProductCommand;
import com.ecommerce.springBoot.application.port.in.CreateProductUseCase;
import com.ecommerce.springBoot.application.port.out.ProductRepositoryPort;
import com.ecommerce.springBoot.domain.model.Product;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepositoryPort productRepository ;
    public CreateProductUseCaseImpl(ProductRepositoryPort productRepository){
        this.productRepository = productRepository;
    }

    public void execute(CreateProductCommand command){
        Product product = new Product(null, command.name(), command.price().floatValue(), command.stock());
        productRepository.save(product);
    }
}
