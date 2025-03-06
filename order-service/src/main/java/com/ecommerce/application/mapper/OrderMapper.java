package com.ecommerce.application.mapper;

import com.ecommerce.application.dto.OrderDTO;
import com.ecommerce.domain.model.Order;

public interface OrderMapper {
    public OrderDTO toDTO(Order order);

    public Order toEntity(OrderDTO dto);

    public Order updateOrderToDto (OrderDTO orderDTO, Order order);
}
