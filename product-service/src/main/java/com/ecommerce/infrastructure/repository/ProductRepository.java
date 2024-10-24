package com.ecommerce.infrastructure.repository;

import com.ecommerce.domain.model.Product;
import com.ecommerce.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;


public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, Long> {

    Mono<Product> findByName(String name);
}
