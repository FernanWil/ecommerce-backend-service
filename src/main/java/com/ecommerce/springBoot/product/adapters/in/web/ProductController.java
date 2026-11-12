package com.ecommerce.springBoot.product.adapters.in.web;

import com.ecommerce.springBoot.product.application.commands.CreateProductCommand;
import com.ecommerce.springBoot.product.application.ports.in.CreateProductUseCase;
import com.ecommerce.springBoot.product.domain.model.Product;
import com.ecommerce.springBoot.product.adapters.in.web.dto.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    final CreateProductUseCase productUseCase;
    public ProductController(CreateProductUseCase productUseCase){
        this.productUseCase = productUseCase;
    }

    @PostMapping
    public ResponseEntity<Product> createProductRequest(@Valid @RequestBody ProductDTO dto){
        if (dto == null) throw new IllegalArgumentException("Invalid information dto");
        CreateProductCommand command = dto.toCommand();
        Product newProduct = productUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }
}
