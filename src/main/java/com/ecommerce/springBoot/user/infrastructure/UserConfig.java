package com.ecommerce.springBoot.user.infrastructure;

import com.ecommerce.springBoot.user.application.ports.in.RegisterUserUseCase;
import com.ecommerce.springBoot.user.domain.port.UserRepositoryPort;
import com.ecommerce.springBoot.user.application.service.RegisterUserUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {

    @Bean
    public RegisterUserUseCase registerUserUseCase(UserRepositoryPort userRepositoryPort, PasswordEncoder passwordEncoder){
        return new RegisterUserUseCaseImpl(userRepositoryPort, passwordEncoder);
    }
}
