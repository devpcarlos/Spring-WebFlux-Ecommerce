package com.ecommerce.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    @NotNull(message = "El campo Id de producto no puede ir vacio")
    private Long productId;
    @NotNull(message = "El campo cantidad no puede ser nulo")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer quantity;
}
