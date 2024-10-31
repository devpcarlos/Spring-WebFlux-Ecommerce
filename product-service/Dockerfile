
# Usa una imagen de Maven para compilar
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .

# Compila solo el módulo product-service
RUN mvn -pl product-service clean install -DskipTests

# Usa una imagen ligera de Java para ejecutar la aplicación
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia el archivo JAR del módulo product-service
COPY --from=build /app/product-service/target/product-service-1.0-SNAPSHOT.jar product.jar

# Expone el puerto 8081 (puerto definido en product-service)
EXPOSE 8081

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "product.jar"]
