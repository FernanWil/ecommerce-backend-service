package com.ecommerce.springBoot.infrastructure.persistence.Product;

import com.ecommerce.springBoot.application.ports.out.Product.ProductRepositoryPort;
import com.ecommerce.springBoot.domain.models.Product;
import com.ecommerce.springBoot.infrastructure.ProductJpaRepositoryInterface;
import org.springframework.stereotype.Repository;

@Repository
public class ProductJpaAdapter implements ProductRepositoryPort {

    final ProductJpaRepositoryInterface repositoryInterface;
    public ProductJpaAdapter(ProductJpaRepositoryInterface repositoryInterface){
        this.repositoryInterface = repositoryInterface;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = new ProductEntity(product.id(), product.name(), product.price(), product.stock());
        ProductEntity savedEntity = repositoryInterface.save(entity);
        return new Product(savedEntity.getId(), savedEntity.getName(), savedEntity.getPrice(), savedEntity.getStock());
    }
}
