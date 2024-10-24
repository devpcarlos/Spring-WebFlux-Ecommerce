package com.ecommerce.application.mapper;

import com.ecommerce.application.dto.OrderDTO;
import com.ecommerce.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDTO toDTO(Order order) {
        return OrderDTO.builder()
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .build();
    }

    public Order toEntity(OrderDTO dto) {
        return Order.builder()
                .productId(dto.getProductId())
                .quantity(dto.getQuantity())
                .build();
    }

    public Order updateOrderToDto (OrderDTO orderDTO, Order order){
        if ( orderDTO == null ) {
            return order; }
        order.setProductId(orderDTO.getProductId());
        order.setQuantity(orderDTO.getQuantity());
        return order;
    }
}
