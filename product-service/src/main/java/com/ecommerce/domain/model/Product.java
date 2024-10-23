package com.ecommerce.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table("products")
public class Product {
    @Id
    private Long id;
    private String name;
    private Double price;
}
