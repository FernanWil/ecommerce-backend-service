package com.ecommerce.springBoot.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    @Column(name = "nombre")
    private final String name;

    @Column(name= "precio")
    private final Float price;

    @Column(name = "cantidad")
    private final Integer stock;

    public ProductEntity(Long id, String name, Float price, Integer stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
