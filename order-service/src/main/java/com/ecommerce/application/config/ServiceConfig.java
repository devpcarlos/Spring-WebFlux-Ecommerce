package com.ecommerce.application.config;

import com.ecommerce.application.mapper.OrderMapper;
import com.ecommerce.application.service.OrderService;
import com.ecommerce.domain.port.OrderPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public OrderService orderService( OrderPort orderPort, OrderMapper orderMapper) {
        return new OrderService(orderPort, orderMapper);
    }
}
