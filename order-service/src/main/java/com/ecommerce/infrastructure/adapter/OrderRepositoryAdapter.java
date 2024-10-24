package com.ecommerce.infrastructure.adapter;

import com.ecommerce.domain.model.Order;
import com.ecommerce.domain.port.OrderPort;
import com.ecommerce.infrastructure.entity.OrderEntity;
import com.ecommerce.infrastructure.entityMapper.OrderEntityMapper;
import com.ecommerce.infrastructure.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class OrderRepositoryAdapter implements OrderPort {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEntityMapper orderEntityMapper;

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
