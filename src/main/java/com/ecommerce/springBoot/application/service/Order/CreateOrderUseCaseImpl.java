package com.ecommerce.springBoot.application.service.Order;

import com.ecommerce.springBoot.application.dto.Order.CreateOrderCommand;
import com.ecommerce.springBoot.application.ports.in.Order.CreateOrderUseCase;
import com.ecommerce.springBoot.application.ports.out.Order.OrderRepositoryPort;
import com.ecommerce.springBoot.application.ports.out.Product.ProductRepositoryPort;
import com.ecommerce.springBoot.domain.models.Order;
import com.ecommerce.springBoot.domain.models.OrderLine;
import com.ecommerce.springBoot.domain.models.Product;
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
