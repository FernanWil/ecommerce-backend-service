package com.ecommerce.springBoot.order.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRespositoryInterface extends JpaRepository<OrderEntity, String> {}
