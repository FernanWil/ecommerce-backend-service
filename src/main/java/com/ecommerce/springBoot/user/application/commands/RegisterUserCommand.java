package com.ecommerce.springBoot.user.application.commands;

public record RegisterUserCommand(
        String name,
        String email,
        String password
) {
}
