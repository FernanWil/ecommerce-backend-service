package com.ecommerce.springBoot.application.port.out.User;

import com.ecommerce.springBoot.domain.model.User;

public interface UserRepositoryPort {
    User createUser( User user);

}
