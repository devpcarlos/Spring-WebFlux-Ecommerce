package com.ecommerce.application;

import com.ecommerce.application.dto.ProductDto;
import com.ecommerce.application.mapper.ProductMapper;
import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.repository.ProductRepository;
import com.ecommerce.infrastructure.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements ProductInterface {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public Flux<ProductDto> getAllProducts() {
        return productRepository.findAll().map(productMapper::toDto);
    }

    public Mono<ProductDto> getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::toDto).switchIfEmpty(Mono.error(new ProductNotFoundException(id)));
    }

    public Mono<ProductDto> createProduct(ProductDto productDto) {
        Product product=productMapper.toProduct(productDto);
        return productRepository.save(product).map(productMapper::toDto);
    }

    public Mono<Void> deleteProduct(Long id) {
        return productRepository.deleteById(id);
    }
}
