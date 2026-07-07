package com.ecommerce.springBoot.domain.model;

import java.io.IOException;
import java.util.UUID;
import java.util.regex.Pattern;

public record User(
        String id,
        String name,
        String email,
        String password
) {
//    public  boolean isValidEmail(String email){
//        if (email == null) return  false;
//        return Pattern.compile(emailRegex).matcher(email).matches();
//    }

    private static final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    public static User createNew(String name, String email, String password){
        if (email == null) {
            System.out.println("Email invalido null");
            return  null;
        };
        String newEmail = String.valueOf(Pattern.compile(emailRegex).matcher(email).matches());
        return new User(
                UUID.randomUUID().toString(),
                name,
                newEmail,
                password
        );
    }
}
