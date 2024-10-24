package com.ecommerce.application.mapper;

import com.ecommerce.application.dto.ProductDto;
import com.ecommerce.domain.model.Product;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class ProductMapper {

    public Product toProduct(ProductDto productDto){
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();
    }

    public ProductDto toDto(Product product){
        return ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public Product updateOrderToDto (ProductDto productDto, Product product){
        if ( productDto == null ) {
            return product; }
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return product;
    }

    public Flux<ProductDto> productDtoFlux(Flux<Product> productFlux){
        return productFlux.map(product -> toDto(product));
    }

}
