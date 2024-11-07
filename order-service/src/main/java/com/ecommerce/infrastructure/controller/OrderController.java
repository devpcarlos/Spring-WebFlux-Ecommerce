package com.ecommerce.infrastructure.controller;

import com.ecommerce.application.service.OrderService;
import com.ecommerce.application.dto.OrderDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "Obtener todas las órdenes", description = "Recupera una lista de todas las órdenes")
    @GetMapping
    public Flux<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @Operation(summary = "Obtener una orden", description = "Recupera una orden por su id")
    @GetMapping("/{id}")
    public Mono<OrderDTO> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @Operation(
            summary = "Crear una nueva orden",
            description = "Crea una nueva orden con los detalles proporcionados")
    @PostMapping
    public Mono<ResponseEntity<OrderDTO>> createOrder(@Valid @RequestBody OrderDTO orderDto) {
        return orderService.createOrder(orderDto).map(ResponseEntity::ok);
    }

    @Operation(summary = "Actualizar una orden")
    @PutMapping("/{id}")
    public Mono<OrderDTO> updateOrder(@Valid @PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(id, orderDTO);
    }

    @Operation(summary = "Elimina una orden", description = "Elimina una orden por su id")
    @DeleteMapping("/{id}")
    public Mono<Void> deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}
