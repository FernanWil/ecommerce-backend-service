package com.ecommerce.springBoot.product.infrastructure;

import com.ecommerce.springBoot.product.application.ports.in.CreateProductUseCase;
import com.ecommerce.springBoot.product.domain.port.ProductRepositoryPort;
import com.ecommerce.springBoot.product.application.service.CreateProductUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepositoryPort respositoryPort){
        return new CreateProductUseCaseImpl(respositoryPort);
    }

}

