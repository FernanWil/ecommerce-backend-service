package com.ecommerce.springBoot.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Table(name = "product")
public class ProductEntity {
    @Id
    private String id;
    @Column(name = "nombre")
    private String name;

    @Column(name= "precio")
    private BigDecimal price;

    @Column(name = "cantidad")
    private Integer stock;

    public ProductEntity(){}
    public ProductEntity(String id, String name, BigDecimal price, Integer stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
