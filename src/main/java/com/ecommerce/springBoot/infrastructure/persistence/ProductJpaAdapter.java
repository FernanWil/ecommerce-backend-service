package com.ecommerce.springBoot.infrastructure.persistence;

import com.ecommerce.springBoot.application.port.out.Product.ProductRepositoryPort;
import com.ecommerce.springBoot.domain.model.Product;
import com.ecommerce.springBoot.infrastructure.JpaRepositoryInterface;
import org.springframework.stereotype.Repository;

@Repository
public class ProductJpaAdapter implements ProductRepositoryPort {

    final JpaRepositoryInterface repositoryInterface;
    public ProductJpaAdapter(JpaRepositoryInterface repositoryInterface){
        this.repositoryInterface = repositoryInterface;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = new ProductEntity(product.id(), product.name(), product.price(), product.stock());
        ProductEntity savedEntity = repositoryInterface.save(entity);
        return new Product(savedEntity.getId(), savedEntity.getName(), savedEntity.getPrice(), savedEntity.getStock());
    }
}
