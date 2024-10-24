package com.ecommerce.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    @NotNull(message = "El campo nombre no puede ir vacio")
    private String name;
    @NotNull(message = "El campo precio no puede ir vacio")
    private Double price;
}
