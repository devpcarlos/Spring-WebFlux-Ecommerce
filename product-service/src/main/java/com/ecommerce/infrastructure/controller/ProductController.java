package com.ecommerce.infrastructure.controller;

import com.ecommerce.application.service.ProductService;
import com.ecommerce.application.dto.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Obtener todos los productos", description = "Recupera una lista de todos los Productos")
    @GetMapping
    public Flux<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @Operation(summary = "Obtener un producto", description = "Recupera un producto por su id")
    @GetMapping("/{id}")
    public Mono<ProductDto> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @Operation(
            summary = "Crear una nuevo producto",
            description = "Crea una nuevo producto con los detalles proporcionados")
    @PostMapping
    public Mono<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @Operation(summary = "Actualizar una orden")
    @PutMapping("/{id}")
    public Mono<ProductDto> updateOrder(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.updateOrder(id, productDto);
    }

    @Operation(summary = "Elimina un producto", description = "Elimina un producto por su id")
    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
