package com.ecommerce.application.config;

import com.ecommerce.application.mapper.ProductMapper;
import com.ecommerce.application.service.ProductService;
import com.ecommerce.domain.port.ProductPort;
import com.ecommerce.infrastructure.adapter.ProductRepositoryAdapter;
import com.ecommerce.infrastructure.mapperEntity.ProductEntityMapper;
import com.ecommerce.infrastructure.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ProductPort productPort(ProductRepository productRepository,  ProductEntityMapper productEntityMapper) {
        return new ProductRepositoryAdapter(productRepository, productEntityMapper);
    }

    @Bean
    public ProductService productService(ProductPort productPort, ProductMapper productMapper) {
        return new ProductService(productPort, productMapper);
    }

}
