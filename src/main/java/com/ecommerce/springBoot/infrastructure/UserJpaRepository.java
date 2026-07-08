package com.ecommerce.springBoot.infrastructure;

import com.ecommerce.springBoot.infrastructure.persistence.User.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
}
