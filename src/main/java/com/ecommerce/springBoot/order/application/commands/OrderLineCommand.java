package com.ecommerce.springBoot.order.application.commands;

public record OrderLineCommand(String productId, Integer quantity) {
}
