package com.ecommerce.springBoot.user.domain.port;

import com.ecommerce.springBoot.user.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User createUser( User user);
    Optional<User> findByEmail(String username);
}
