# Usa una imagen de Maven para compilar
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .

# Compila solo el módulo order-service
RUN mvn -pl order-service clean install -DskipTests

# Usa una imagen ligera de Java para ejecutar la aplicación
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia el archivo JAR del módulo order-service
COPY --from=build /app/order-service/target/order-service-1.0-SNAPSHOT.jar order.jar

# Expone el puerto 8082 (puerto definido en order-service)
EXPOSE 8082

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "order.jar"]
