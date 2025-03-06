package com.ecommerce.infrastructure.configuracion;

import com.ecommerce.domain.port.OrderPort;
import com.ecommerce.infrastructure.adapter.OrderRepositoryAdapter;
import com.ecommerce.infrastructure.entityMapper.OrderEntityMapper;
import com.ecommerce.infrastructure.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public OrderPort orderPort(OrderRepository orderRepository, OrderEntityMapper orderEntityMapper) {
        return new OrderRepositoryAdapter(orderRepository, orderEntityMapper);
    }
}
