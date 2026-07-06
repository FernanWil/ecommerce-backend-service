package com.ecommerce.springBoot.application.service;

import com.ecommerce.springBoot.application.dto.CreateProductCommand;
import com.ecommerce.springBoot.application.port.in.Product.CreateProductUseCase;
import com.ecommerce.springBoot.application.port.out.Product.ProductRepositoryPort;
import com.ecommerce.springBoot.domain.model.Product;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepositoryPort productRepository;
    public CreateProductUseCaseImpl(ProductRepositoryPort productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product execute(CreateProductCommand command){
        if (Boolean.parseBoolean(command.name())){
            throw new RuntimeException("Product " + command.name() + " it's exist");
        }
        Product product = Product.createNew(command.name(), command.price(), command.stock());
        return  productRepository.save(product);
    }
}
