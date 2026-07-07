package com.ecommerce.springBoot.application.ports.out.User;

import com.ecommerce.springBoot.domain.model.User;

public interface UserRepositoryPort {
    User createUser( User user);

}
