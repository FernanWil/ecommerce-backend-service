package com.ecommerce.springBoot.application.service.User;

import com.ecommerce.springBoot.application.dto.User.RegisterUserCommand;
import com.ecommerce.springBoot.application.ports.in.User.RegisterUserUseCase;
import com.ecommerce.springBoot.application.ports.out.User.UserRepositoryPort;
import com.ecommerce.springBoot.domain.model.User;

public class RegisterUserUseCaseImpl implements RegisterUserUseCase {
    final UserRepositoryPort repositoryPort;
    public RegisterUserUseCaseImpl(UserRepositoryPort repositoryPort){
        this.repositoryPort = repositoryPort;
    }

    @Override
    public User execute(RegisterUserCommand userCommand) {
        User newUser = User.createNew(userCommand.name(), userCommand.email(), userCommand.password());
        User.isValidUserName(userCommand.name());
        User.isValidEmail(userCommand.email());
        return  repositoryPort.createUser(newUser);

    }
}
