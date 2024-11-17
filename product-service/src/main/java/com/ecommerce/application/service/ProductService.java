package com.ecommerce.application.service;

import com.ecommerce.application.dto.ProductDto;
import com.ecommerce.application.mapper.ProductMapper;
import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.port.ProductPort;
import com.ecommerce.exception.ProductNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class ProductService  {

    private final ProductPort productPort;

    private final ProductMapper productMapper;

    public Flux<ProductDto> getAllProducts() {
        return productPort.findAll().map(productMapper::toDto);
    }

    public Mono<ProductDto> getProductById(Long id) {
        return productPort.findById(id).map(productMapper::toDto).switchIfEmpty(Mono.error(new ProductNotFoundException(id)));
    }

    public Mono<ProductDto> createProduct(ProductDto productDto) {
        Product product=productMapper.toProduct(productDto);
        return productPort.save(product).map(productMapper::toDto);
    }

    public Mono<ProductDto> updateOrder(Long id, ProductDto productDto) {
        return productPort.findById(id)
                .flatMap(order -> {
                    productMapper.updateOrderToDto(productDto, order);
                    return productPort.save(order);
                })
                .map(productMapper::toDto);
    }

    public Mono<Void> deleteProduct(Long id) {
        return productPort.deleteById(id);
    }
}
