package com.ecommerce.springBoot.order.adapters.in.web;

import com.ecommerce.springBoot.order.adapters.in.web.dto.OrderDto;
import com.ecommerce.springBoot.order.application.commands.CreateOrderCommand;
import com.ecommerce.springBoot.order.application.ports.in.CreateOrderUseCase;
import com.ecommerce.springBoot.order.domain.model.Order;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    final CreateOrderUseCase orderUseCase;
    public OrderController(CreateOrderUseCase orderUseCase){
        this.orderUseCase = orderUseCase;
    }
    @PostMapping
    public ResponseEntity<Order> createOrderRequest(@Valid @RequestBody OrderDto orderDto){
        if(orderDto == null) throw  new IllegalArgumentException("Invalid information dto");
        CreateOrderCommand orderCommand = orderDto.toCommand();
        Order newOrder = orderUseCase.execute(orderCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }
}
