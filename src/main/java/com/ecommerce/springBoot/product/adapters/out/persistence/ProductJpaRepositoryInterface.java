package com.ecommerce.springBoot.product.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepositoryInterface extends JpaRepository<ProductEntity, String> {
}
