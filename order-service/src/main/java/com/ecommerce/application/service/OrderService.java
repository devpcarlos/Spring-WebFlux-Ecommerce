package com.ecommerce.application.service;

import com.ecommerce.application.dto.OrderDTO;
import com.ecommerce.application.mapper.OrderMapper;
import com.ecommerce.domain.port.OrderPort;
import com.ecommerce.application.exceptions.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class OrderService {

    private final OrderPort orderPort;

    private final OrderMapper orderMapper;

    public Flux<OrderDTO> getAllOrders() {
        return orderPort.findAll().map(orderMapper::toDTO);
    }

    public Mono<OrderDTO> getOrderById(Long id) {
        return orderPort.findById(id).map(orderMapper::toDTO).switchIfEmpty(Mono.error(new OrderNotFoundException(id)));
    }

    public Mono<OrderDTO> createOrder(OrderDTO orderDTO) {
        return orderPort.save(orderMapper.toEntity(orderDTO)).map(orderMapper::toDTO);
    }

    public Mono<OrderDTO> updateOrder(Long id, OrderDTO orderDTO) {
        return orderPort.findById(id)
                .switchIfEmpty(Mono.error(new OrderNotFoundException(id)))
                .flatMap(order -> {
                    orderMapper.updateOrderToDto(orderDTO, order);
                    return orderPort.update(order);
                })
                .map(orderMapper::toDTO);
    }

    public Mono<Void> deleteOrder(Long id) {
        return orderPort.deleteById(id);
    }
}
