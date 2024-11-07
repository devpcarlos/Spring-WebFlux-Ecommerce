package com.ecommerce.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    private Long id;
    private Long productId;
    private Integer quantity;
}
