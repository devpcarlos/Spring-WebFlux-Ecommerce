package com.ecommerce.domain.port;

import com.ecommerce.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductPort {
    Mono<Product> findById(Long id);
    Flux<Product> findAll();
    Mono<Product> save(Product product);
    Mono<Product> update(Product product);
    Mono<Void> deleteById(Long id);
}
