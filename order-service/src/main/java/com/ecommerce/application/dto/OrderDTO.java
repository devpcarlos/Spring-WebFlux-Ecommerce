package com.ecommerce.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    @NotNull(message = "El campo Id de producto no puede ir vacio")
    private Long productId;
    @NotNull(message = "El campo cantidad no puede ir vacio")
    private Integer quantity;
}
