package com.ecommerce.springBoot.infrastructure.persistence.JpaRepository.Order;

import com.ecommerce.springBoot.infrastructure.persistence.Order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRespositoryInterface extends JpaRepository<OrderEntity, String> {}
