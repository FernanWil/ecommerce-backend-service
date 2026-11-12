package com.ecommerce.springBoot.user.application.service;

import com.ecommerce.springBoot.user.application.commands.RegisterUserCommand;
import com.ecommerce.springBoot.user.application.ports.in.RegisterUserUseCase;
import com.ecommerce.springBoot.user.domain.port.UserRepositoryPort;
import com.ecommerce.springBoot.user.domain.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegisterUserUseCaseImpl implements RegisterUserUseCase {
    final UserRepositoryPort repositoryPort;
    final PasswordEncoder passwordEncoder;
    public RegisterUserUseCaseImpl(UserRepositoryPort repositoryPort, PasswordEncoder passwordEncoder){
        this.repositoryPort = repositoryPort; this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User execute(RegisterUserCommand userCommand) {
        // Utilizar por ahora esa exception
//        if(userCommand.email() == null) throw new IllegalArgumentException("Email not found");
        String passwordCrypt = passwordEncoder.encode(userCommand.password());
        User newUser = User.createNew(userCommand.name(), userCommand.email(), passwordCrypt);
        return  repositoryPort.createUser(newUser);

    }
}
