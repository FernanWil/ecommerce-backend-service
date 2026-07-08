package com.ecommerce.springBoot.domain.model;

import java.util.UUID;
import java.util.regex.Pattern;

public record User(
        String id,
        String name,
        String email,
        String password
) {
    private static final String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static User createNew(String name, String email, String password){
        if (email == null) throw new IllegalArgumentException("Invalid Email ");
        boolean newEmail =  Pattern.compile(emailRegex).matcher(email).matches();
        if (!newEmail) throw new IllegalArgumentException("Invalid Email format");
        return new User(
                UUID.randomUUID().toString(),
                name,
                email,
                password
        );
    }
}
