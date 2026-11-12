package com.ecommerce.springBoot.order.infrastructure;

import com.ecommerce.springBoot.order.application.ports.in.CreateOrderUseCase;
import com.ecommerce.springBoot.order.domain.port.OrderRepositoryPort;
import com.ecommerce.springBoot.product.domain.port.ProductRepositoryPort;
import com.ecommerce.springBoot.order.application.service.CreateOrderUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {
    @Bean
    public CreateOrderUseCase createOrderUseCase( OrderRepositoryPort orderRepositoryPort, ProductRepositoryPort productRepositoryPort){
        return new CreateOrderUseCaseImpl(orderRepositoryPort, productRepositoryPort);
    }
}
