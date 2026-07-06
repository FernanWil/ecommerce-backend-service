package com.ecommerce.springBoot.infrastructure.controller.dto;
import com.ecommerce.springBoot.application.dto.CreateProductCommand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductDTO(
        @NotBlank(message = "Name cannot be blank")
        String name,

        @NotNull(message = "Price cannot be null")
        @Positive(message = "Price must be greater than 0")
        BigDecimal price,

        @NotNull(message = "Stock cannot be null")
        @Positive(message = "Stock must be greater than 0")
        Integer stock
) {
    // Un método utilitario para mapear de la Web hacia el Command de Aplicación
    public CreateProductCommand toCommand() {
        return new CreateProductCommand(this.name, this.price, this.stock);
    }
}
