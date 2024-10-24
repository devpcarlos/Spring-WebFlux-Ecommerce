package com.ecommerce.infrastructure.entityMapper;

import com.ecommerce.domain.model.Order;
import com.ecommerce.infrastructure.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityMapper {

    public Order toDomain(OrderEntity entity) {
        return Order.builder()
                .id(entity.getId())
                .productId(entity.getProductId())
                .quantity(entity.getQuantity())
                .build();
    }

    public OrderEntity toEntity(Order order) {
        return OrderEntity.builder()
                .id(order.getId())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .build();
    }

    public OrderEntity updateEntityFromOrder(Order order, OrderEntity entity) {
        if (order == null) {
            return entity;
        }
        entity.setProductId(order.getProductId());
        entity.setQuantity(order.getQuantity());
        return entity;
    }
}
