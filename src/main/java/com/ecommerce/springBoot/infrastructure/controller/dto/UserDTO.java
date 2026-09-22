package com.ecommerce.springBoot.infrastructure.controller.dto;

import com.ecommerce.springBoot.application.dto.User.RegisterUserCommand;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UserDTO(
        @NotNull(message = "Name cannot be null")
        String name,

        @NotNull(message = "Email cannot be null")
        @Email
        String email,
        @NotNull(message = "Password cannot be null")
        String password
) {
    public RegisterUserCommand toCommand(){
        return new RegisterUserCommand(this.name, this.email,this.password);
    }
}
