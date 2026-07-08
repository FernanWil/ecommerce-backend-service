package com.ecommerce.springBoot.infrastructure.Configuration.User;

import com.ecommerce.springBoot.application.ports.in.User.RegisterUserUseCase;
import com.ecommerce.springBoot.application.ports.out.User.UserRepositoryPort;
import com.ecommerce.springBoot.application.service.User.RegisterUserUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public RegisterUserUseCase registerUserUseCase(UserRepositoryPort userRepositoryPort){
        return new RegisterUserUseCaseImpl(userRepositoryPort);
    }
}
