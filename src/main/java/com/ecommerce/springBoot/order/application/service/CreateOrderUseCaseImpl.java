package com.ecommerce.springBoot.order.application.service;

import com.ecommerce.springBoot.order.application.commands.CreateOrderCommand;
import com.ecommerce.springBoot.order.application.ports.in.CreateOrderUseCase;
import com.ecommerce.springBoot.order.domain.port.OrderRepositoryPort;
import com.ecommerce.springBoot.product.domain.port.ProductRepositoryPort;
import com.ecommerce.springBoot.order.domain.model.Order;
import com.ecommerce.springBoot.order.domain.model.OrderLine;
import com.ecommerce.springBoot.product.domain.model.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class CreateOrderUseCaseImpl implements CreateOrderUseCase {
    final ProductRepositoryPort productRepositoryPort;
    final OrderRepositoryPort orderRepositoryPort;

        public CreateOrderUseCaseImpl(OrderRepositoryPort orderRepositoryPort, ProductRepositoryPort productRepositoryPort){
        this.orderRepositoryPort = orderRepositoryPort;
        this.productRepositoryPort = productRepositoryPort;
    }

    @Transactional
    @Override
    public Order execute(CreateOrderCommand command) {
        List<OrderLine> listOrderLine = command.items().stream().map(item -> {
            Product product = productRepositoryPort.findById(item.productId()).orElseThrow(() -> new IllegalArgumentException("Product not found: "+ item.productId()));
            if (product.stock() < item.quantity()) throw new IllegalArgumentException("Insufficient stock for product: " + product.name());
            Product updateProduct = new Product(product.id(),product.name(),product.price(), product.stock()- item.quantity());
            productRepositoryPort.save(updateProduct);
            return OrderLine.createNew(product.id(), item.quantity(), product.price());
        }).toList();
        Order newOrder = Order.createNew(command.userId(), listOrderLine);
        return this.orderRepositoryPort.saveOrder(newOrder);
    }
}
