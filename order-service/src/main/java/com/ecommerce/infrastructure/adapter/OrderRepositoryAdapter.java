package com.ecommerce.infrastructure.adapter;

import com.ecommerce.domain.model.Order;
import com.ecommerce.domain.port.OrderPort;
import com.ecommerce.infrastructure.entity.OrderEntity;
import com.ecommerce.infrastructure.entityMapper.OrderEntityMapper;
import com.ecommerce.infrastructure.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderPort {

    private final OrderRepository orderRepository;

    private final OrderEntityMapper orderEntityMapper;

    @Override
    public Mono<Order> findById(Long id) {
        return orderRepository.findById(id).map(orderEntityMapper::toDomain);
    }

    @Override
    public Flux<Order> findAll() {
        return orderRepository.findAll()
                .map(orderEntityMapper::toDomain);
    }

    @Override
    public Mono<Order> save(Order order) {
        OrderEntity entity = orderEntityMapper.toEntity(order);
        return orderRepository.save(entity).map(orderEntityMapper::toDomain);
    }

    @Override
    public Mono<Order> update(Order order) {
        return orderRepository.findById(order.getId())
                .flatMap(existingEntity -> {
                    OrderEntity updatedEntity = orderEntityMapper.updateEntityFromOrder(order, existingEntity);
                    return orderRepository.save(updatedEntity);
                })
                .map(orderEntityMapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return orderRepository.deleteById(id);
    }
}
