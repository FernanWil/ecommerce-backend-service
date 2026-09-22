package com.ecommerce.springBoot.domain.models;

import java.util.UUID;
import java.util.regex.Pattern;

public record User(
        String id,
        String name,
        String email,
        String password
) {
    private static final Pattern emailRegex = Pattern.compile( "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern userNamePatter = Pattern.compile("^[a-zA-Z0-9._-]{3,20}$");

    public static void isValidEmail(String email){
        if (email == null) throw new IllegalArgumentException("Invalid Email ");
        boolean newEmail =  emailRegex.matcher(email).matches();
        if (!newEmail) throw new IllegalArgumentException("Invalid Email format");
    }

    public static void isValidUserName(String name){
        if (name == null) throw new IllegalArgumentException("Username don't must be null");
        boolean userNameMatcher = userNamePatter.matcher(name).matches();
//        if (name.length() < 3) throw new IllegalArgumentException("Username must be at least 3 character long");
//        if (name.length() > 20) throw new IllegalArgumentException("Username must be max 20 character long");
        if (name.contains("admin") || name.contains("root")) throw  new IllegalArgumentException("Username invalid");
        if (name.startsWith(".") || name.endsWith(".")) throw new IllegalArgumentException("Username invalid: don't start or end with a '.' ");
        if (!userNameMatcher) throw new IllegalArgumentException("Username invalid");
    }

    public static User createNew(String name, String email, String password){
        isValidUserName(name);
        isValidEmail(email);
        return new User(
                UUID.randomUUID().toString(),
                name,
                email,
                password
        );
    }
}
