package com.ecommerce;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Prodcut API", version = "1.0", description = "Documentación de la API de Productos"))
public class ProductMain {
    public static void main(String[] args) {
        SpringApplication.run(ProductMain.class, args);
    }
}