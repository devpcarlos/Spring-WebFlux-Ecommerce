package com.ecommerce.infrastructure.controller;

import com.ecommerce.application.OrderService;
import com.ecommerce.application.dto.OrderDTO;
import com.ecommerce.application.mapper.OrderMapper;
import com.ecommerce.domain.model.Order;
import com.ecommerce.infrastructure.exceptions.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping
    public Flux<OrderDTO> getAllOrders() {
        return orderService.getAllOrders().map(orderMapper::toDTO);
    }

    @GetMapping("/{id}")
    public Mono<OrderDTO> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id).map(orderMapper::toDTO).switchIfEmpty(Mono.error(new OrderNotFoundException(id)));
    }

    @PostMapping
    public Mono<OrderDTO> createOrder(@RequestBody OrderDTO orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        return orderService.createOrder(order).map(orderMapper::toDTO);

    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}
