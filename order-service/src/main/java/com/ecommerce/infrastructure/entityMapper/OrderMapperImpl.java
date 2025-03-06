package com.ecommerce.infrastructure.entityMapper;

import com.ecommerce.application.dto.OrderDTO;
import com.ecommerce.application.mapper.OrderMapper;
import com.ecommerce.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO toDTO(Order order) {
        return OrderDTO.builder()
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .build();
    }

    @Override
    public Order toEntity(OrderDTO dto) {
        return Order.builder()
                .productId(dto.getProductId())
                .quantity(dto.getQuantity())
                .build();
    }

    @Override
    public Order updateOrderToDto(OrderDTO orderDTO, Order order) {
        if ( orderDTO == null ) {
            return order; }
        order.setProductId(orderDTO.getProductId());
        order.setQuantity(orderDTO.getQuantity());
        return order;
    }
}

