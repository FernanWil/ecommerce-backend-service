package com.ecommerce.springBoot.domain.model;

import java.util.regex.Pattern;

public record User(
        Integer id,
        String name,
        String email,
        String password
) {
    private static final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    public  boolean isValidEmail(String email){
        if (email == null) return  false;
        return Pattern.compile(emailRegex).matcher(email).matches();
    }
}
