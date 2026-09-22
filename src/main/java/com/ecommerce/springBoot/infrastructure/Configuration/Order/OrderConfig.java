package com.ecommerce.springBoot.infrastructure.Configuration.Order;

import com.ecommerce.springBoot.application.ports.in.Order.CreateOrderUseCase;
import com.ecommerce.springBoot.application.ports.out.Order.OrderRepositoryPort;
import com.ecommerce.springBoot.application.ports.out.Product.ProductRepositoryPort;
import com.ecommerce.springBoot.application.service.Order.CreateOrderUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {
    @Bean
    public CreateOrderUseCase createOrderUseCase( OrderRepositoryPort orderRepositoryPort, ProductRepositoryPort productRepositoryPort){
        return new CreateOrderUseCaseImpl(orderRepositoryPort, productRepositoryPort);
    }
}
