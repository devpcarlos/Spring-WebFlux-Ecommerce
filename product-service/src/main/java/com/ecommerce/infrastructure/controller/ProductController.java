package com.ecommerce.infrastructure.controller;

import com.ecommerce.application.service.ProductService;
import com.ecommerce.application.dto.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Recupera una lista de todos los Productos")
    public Flux<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un producto", description = "Recupera un producto por su id")
    public Mono<ProductDto> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    @Operation(
            summary = "Crear una nuevo producto",
            description = "Crea una nuevo producto con los detalles proporcionados")
    public Mono<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto", description = "Actualiza un producto con los detalles proporcionados")
    public Mono<ProductDto> updateProduct(@Valid @PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.updateOrder(id, productDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un producto", description = "Elimina un producto por su id")
    public Mono<Void> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
