package com.ecommerce.springBoot.infrastructure;

import com.ecommerce.springBoot.infrastructure.persistence.Product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepositoryInterface extends JpaRepository<ProductEntity, String> {
}
