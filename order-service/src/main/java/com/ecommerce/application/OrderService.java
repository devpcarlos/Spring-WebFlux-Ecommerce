package com.ecommerce.application;

import com.ecommerce.application.dto.OrderDTO;
import com.ecommerce.application.mapper.OrderMapper;
import com.ecommerce.domain.model.Order;
import com.ecommerce.domain.repository.OrderRepository;
import com.ecommerce.infrastructure.exceptions.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public Flux<OrderDTO> getAllOrders() {
        return orderRepository.findAll().map(orderMapper::toDTO);
    }

    public Mono<OrderDTO> getOrderById(Long id) {
        return orderRepository.findById(id).map(orderMapper::toDTO).switchIfEmpty(Mono.error(new OrderNotFoundException(id)));
    }

    public Mono<OrderDTO> createOrder(OrderDTO orderDTO) {
        return orderRepository.save(orderMapper.toEntity(orderDTO)).map(orderMapper::toDTO);
    }

    public Mono<Void> deleteOrder(Long id) {
        return orderRepository.deleteById(id);
    }
}
