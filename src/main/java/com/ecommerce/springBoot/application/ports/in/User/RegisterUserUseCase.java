package com.ecommerce.springBoot.application.ports.in.User;

import com.ecommerce.springBoot.application.dto.User.RegisterUserCommand;
import com.ecommerce.springBoot.domain.models.User;

public interface RegisterUserUseCase {
    User execute(RegisterUserCommand userCommand);

}
