package com.ecommerce.springBoot.infrastructure.persistence.User;

import com.ecommerce.springBoot.application.ports.out.User.UserRepositoryPort;
import com.ecommerce.springBoot.domain.model.User;
import com.ecommerce.springBoot.infrastructure.UserJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserJpaAdapter implements UserRepositoryPort {

    final UserJpaRepository userRepository;
    public UserJpaAdapter(UserJpaRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(User user) {
        UserEntity entity = new UserEntity(user.id(), user.name(), user.email(), user.password());
        UserEntity savedEntity = userRepository.save(entity);
        return new User(savedEntity.getId(), savedEntity.getName(), savedEntity.getEmail(), savedEntity.getPassword());
    }
}
