package com.ecommerce.springBoot.infrastructure.controller.Product;

import com.ecommerce.springBoot.application.dto.Product.CreateProductCommand;
import com.ecommerce.springBoot.application.ports.in.Product.CreateProductUseCase;
import com.ecommerce.springBoot.domain.model.Product;
import com.ecommerce.springBoot.infrastructure.controller.dto.ProductDTO;
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
        if (dto == null) System.out.println("No se encontró ningun producto ");
        CreateProductCommand command = dto.toCommand();
        Product newProduct = productUseCase.execute(command);

        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }
}
