package com.ecommerce.springBoot.product.adapters.out.persistence;

import com.ecommerce.springBoot.product.domain.port.ProductRepositoryPort;
import com.ecommerce.springBoot.product.domain.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

    @Override
    public Optional<Product> findById(String productId) {
        return repositoryInterface.findById(productId).map(product ->
                new Product(product.getId(), product.getName(), product.getPrice(), product.getStock()));
    }
}
