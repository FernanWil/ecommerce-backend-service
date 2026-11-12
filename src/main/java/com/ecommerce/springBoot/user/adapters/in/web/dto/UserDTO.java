package com.ecommerce.springBoot.user.adapters.in.web.dto;

import com.ecommerce.springBoot.user.application.commands.RegisterUserCommand;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(
        @NotNull(message = "Name cannot be null")
        @NotBlank
        String name,

        @NotNull(message = "Email cannot be null")
        @Email
        @NotBlank
        String email,

        @NotNull(message = "Password cannot be null")
        @NotBlank
        String password
) {
    public RegisterUserCommand toCommand(){
        return new RegisterUserCommand(this.name, this.email,this.password);
    }
}
