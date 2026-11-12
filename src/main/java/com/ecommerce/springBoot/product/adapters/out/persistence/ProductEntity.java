package com.ecommerce.springBoot.product.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;



@Entity
@Getter
@Setter
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
