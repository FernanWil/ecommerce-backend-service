package com.ecommerce.springBoot.application.service.Order;

import com.ecommerce.springBoot.application.dto.Order.CreateOrderCommand;
import com.ecommerce.springBoot.application.ports.in.Order.CreateOrderUseCase;
import com.ecommerce.springBoot.application.ports.out.Order.OrderRepositoryPort;
import com.ecommerce.springBoot.application.ports.out.Product.ProductRepositoryPort;
import com.ecommerce.springBoot.application.ports.out.User.UserRepositoryPort;
import com.ecommerce.springBoot.domain.models.Order;

public class CreateOrderUseCaseImpl implements CreateOrderUseCase {
    final ProductRepositoryPort productRepositoryPort;
    final UserRepositoryPort userRepositoryPort;
    final OrderRepositoryPort orderRepositoryPort;

    public CreateOrderUseCaseImpl(ProductRepositoryPort productRepositoryPort, UserRepositoryPort userRepositoryPort, OrderRepositoryPort orderRepositoryPort){
        this.productRepositoryPort = productRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
        this.orderRepositoryPort = orderRepositoryPort;
    }
    @Override
    public Order execute(CreateOrderCommand command) {

        return null;
    }
}
