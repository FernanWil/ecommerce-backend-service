package com.ecommerce.springBoot.user.application.ports.in;

import com.ecommerce.springBoot.user.application.commands.RegisterUserCommand;
import com.ecommerce.springBoot.user.domain.model.User;

public interface RegisterUserUseCase {
    User execute(RegisterUserCommand userCommand);

}
