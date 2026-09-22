package com.ecommerce.springBoot.infrastructure.persistence.Product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;



@Entity
@Data
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    private String id;
    @Column(name = "nombre")
    private String name;

    @Column(name= "price")
    private BigDecimal price;

    @Column(name = "stock")
    private Integer stock;
}
