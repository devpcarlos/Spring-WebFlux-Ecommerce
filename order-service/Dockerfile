# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo pom.xml y el directorio src
COPY pom.xml .
COPY src ./src

# Construir la aplicación
RUN ./mvnw clean package -DskipTests

# Usar una imagen base de OpenJDK para la ejecución
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR desde el contenedor de construcción
COPY --from=build /app/target/order-service-1.0-SNAPSHOT.jar order-service.jar

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8082

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "order-service.jar"]
