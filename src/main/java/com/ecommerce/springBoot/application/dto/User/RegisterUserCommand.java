package com.ecommerce.springBoot.application.dto.User;

import com.ecommerce.springBoot.domain.model.User;

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
