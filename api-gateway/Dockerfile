# Usa una imagen de Maven para compilar
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .

# Compila solo el módulo api-gateway
RUN mvn -pl api-gateway clean install -DskipTests

# Usa una imagen ligera de Java para ejecutar la aplicación
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia el archivo JAR del módulo api-gateway
COPY --from=build /app/api-gateway/target/api-gateway-1.0-SNAPSHOT.jar gateway.jar

# Expone el puerto 8080 (puerto definido en api-gateway)
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "gateway.jar"]
