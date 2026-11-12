package com.ecommerce.springBoot.user.adapters.out.persistence;

import com.ecommerce.springBoot.user.domain.port.UserRepositoryPort;
import com.ecommerce.springBoot.user.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserJpaAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;
    public UserJpaAdapter(UserJpaRepository userJpaRepository){
        this.userJpaRepository = userJpaRepository;
    }
    @Override
    public User createUser(User user) {
        UserEntity entity = new UserEntity(user.id(), user.name(), user.email(), user.passwordHash());
        UserEntity savedEntity = userJpaRepository.save(entity);
        return new User(savedEntity.getId(), savedEntity.getName(), savedEntity.getEmail(), savedEntity.getPassword());
    }

    @Override
    public Optional<User> findByEmail(String username) {
            return userJpaRepository.findByEmail(username).map(entity -> new User(entity.getId(), entity.getName(), entity.getEmail(), entity.getPassword()));
    }
}
