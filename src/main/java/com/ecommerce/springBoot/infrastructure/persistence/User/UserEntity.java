package com.ecommerce.springBoot.infrastructure.persistence.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private String id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "correo")
    private String email;

    @Column(name = "contrasena")
    private String password;
}
