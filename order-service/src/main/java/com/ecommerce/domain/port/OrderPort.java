package com.ecommerce.domain.port;

import com.ecommerce.domain.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderPort {
    Mono<Order> findById(Long id);
    Flux<Order> findAll();
    Mono<Order> save(Order order);
    Mono<Order> update(Order order);
    Mono<Void> deleteById(Long id);
}
