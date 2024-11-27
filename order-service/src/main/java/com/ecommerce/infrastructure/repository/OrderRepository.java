package com.ecommerce.infrastructure.repository;

import com.ecommerce.infrastructure.entity.OrderEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ReactiveCrudRepository<OrderEntity, Long> {
}
