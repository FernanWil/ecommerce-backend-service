package com.ecommerce.springBoot.application.service.Product;

import com.ecommerce.springBoot.application.dto.Product.CreateProductCommand;
import com.ecommerce.springBoot.application.ports.in.Product.CreateProductUseCase;
import com.ecommerce.springBoot.application.ports.out.Product.ProductRepositoryPort;
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
