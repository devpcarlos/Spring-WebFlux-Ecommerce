package com.ecommerce.infrastructure.mapperEntity;

import com.ecommerce.domain.model.Product;
import com.ecommerce.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapper {

    public Product toDomain(ProductEntity entity) {
        return Product.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
    }

    public ProductEntity toEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public ProductEntity updateEntityFromOrder(Product product, ProductEntity entity) {
        if (product == null) {
            return entity;
        }
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        return entity;
    }
}
