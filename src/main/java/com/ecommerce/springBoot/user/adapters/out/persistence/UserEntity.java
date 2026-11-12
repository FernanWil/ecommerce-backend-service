package com.ecommerce.springBoot.user.adapters.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private String id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "correo", nullable = false, unique = true)
    private String email;

    @Column(name = "contrasena")
    private String password;
}
