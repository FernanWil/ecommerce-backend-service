package com.ecommerce.springBoot.product.application.service;

import com.ecommerce.springBoot.product.application.commands.CreateProductCommand;
import com.ecommerce.springBoot.product.application.ports.in.CreateProductUseCase;
import com.ecommerce.springBoot.product.domain.model.Product;
import com.ecommerce.springBoot.product.domain.port.ProductRepositoryPort;

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
