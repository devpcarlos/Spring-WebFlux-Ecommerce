package com.ecommerce.application.mapper;

import com.ecommerce.application.dto.OrderDTO;
import com.ecommerce.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDTO toDTO(Order order) {
        return new OrderDTO(order.getId(), order.getProductId(), order.getQuantity());
    }

    public Order toEntity(OrderDTO dto) {
        return new Order(dto.getId(), dto.getProductId(), dto.getQuantity());
    }
}
