package com.ecommerce.springBoot.application.dto.User;

public record RegisterUserCommand(
        String name,
        String email,
        String password
) {
//    public void User{
//        final User user;
//        public RegisterUserCommand(User user){
//            this.user = user;
//        }
//    }
}
