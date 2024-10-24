package com.ecommerce.infrastructure.repository;

import com.ecommerce.domain.model.Order;
import com.ecommerce.infrastructure.entity.OrderEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderRepository extends ReactiveCrudRepository<OrderEntity, Long> {
}
