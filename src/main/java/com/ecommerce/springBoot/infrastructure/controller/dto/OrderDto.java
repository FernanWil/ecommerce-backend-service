package com.ecommerce.springBoot.infrastructure.controller.dto;

import com.ecommerce.springBoot.application.dto.Order.CreateOrderCommand;
import com.ecommerce.springBoot.application.dto.Order.OrderLineCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public record OrderDto (
        @NotBlank(message =  "UserId cannot be blank")
        String userId,
        List<OrderLineDto> items

){
    public CreateOrderCommand toCommand(){
        List<OrderLineCommand> list = new ArrayList<>();
        for (OrderLineDto item: items){
            list.add(new OrderLineCommand(item.productId(),item.quantity()));
        }
        return new CreateOrderCommand(this.userId,list);
    }
}
