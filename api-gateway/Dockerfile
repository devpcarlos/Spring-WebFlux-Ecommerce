
# Usa una imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim as builder

LABEL authors="Carlos"

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y descarga las dependencias
COPY pom.xml .
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Crea la imagen final
FROM openjdk:17-jre-slim
VOLUME /tmp
COPY --from=builder /app/target/api-gateway-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar","/api-gateway.jar"]

