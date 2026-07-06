package com.ecommerce.springBoot.infrastructure.Configuration;

import com.ecommerce.springBoot.application.port.in.Product.CreateProductUseCase;
import com.ecommerce.springBoot.application.port.out.Product.ProductRepositoryPort;
import com.ecommerce.springBoot.application.service.CreateProductUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepositoryPort respositoryPort){
        return new CreateProductUseCaseImpl(respositoryPort);
    }

}

