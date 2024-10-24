package com.ecommerce.infrastructure.adapter;

import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.port.ProductPort;
import com.ecommerce.infrastructure.entity.ProductEntity;
import com.ecommerce.infrastructure.mapperEntity.ProductEntityMapper;
import com.ecommerce.infrastructure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductRepositoryAdapter implements ProductPort {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductEntityMapper productEntityMapper;

    @Override
    public Mono<Product> findById(Long id) {
        return productRepository.findById(id).map(productEntityMapper::toDomain);
    }

    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll()
                .map(productEntityMapper::toDomain);
    }

    @Override
    public Mono<Product> save(Product product) {
        ProductEntity entity = productEntityMapper.toEntity(product);
        return productRepository.save(entity).map(productEntityMapper::toDomain);
    }

    @Override
    public Mono<Product> update(Product product) {
        return productRepository.findById(product.getId())
                .flatMap(existingEntity -> {
                    ProductEntity updatedEntity = productEntityMapper.updateEntityFromOrder(product, existingEntity);
                    return productRepository.save(updatedEntity);
                })
                .map(productEntityMapper::toDomain);
    }


    @Override
    public Mono<Void> deleteById(Long id) {
        return productRepository.deleteById(id);
    }
}
