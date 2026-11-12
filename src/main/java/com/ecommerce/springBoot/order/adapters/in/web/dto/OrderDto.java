package com.ecommerce.springBoot.order.adapters.in.web.dto;

import com.ecommerce.springBoot.order.application.commands.CreateOrderCommand;
import com.ecommerce.springBoot.order.application.commands.OrderLineCommand;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;


public record OrderDto (
        @NotBlank(message =  "UserId cannot be blank")
        String userId,
        @Valid
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
