package com.ecommerce.springBoot.infrastructure.controller.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductDTO {
    @NotBlank(message = "Name cannot be null")
    String name;
    @Positive(message = "Number must be greater than 0")
    Float price;
    @Positive(message = "Number must be greater than 0")
    Long stock;

}
