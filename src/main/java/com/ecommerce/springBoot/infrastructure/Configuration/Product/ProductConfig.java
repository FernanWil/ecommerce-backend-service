package com.ecommerce.springBoot.infrastructure.Configuration.Product;

import com.ecommerce.springBoot.application.ports.in.Product.CreateProductUseCase;
import com.ecommerce.springBoot.application.ports.out.Product.ProductRepositoryPort;
import com.ecommerce.springBoot.application.service.Product.CreateProductUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepositoryPort respositoryPort){
        return new CreateProductUseCaseImpl(respositoryPort);
    }

}

