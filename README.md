


![Arquitectura microservicio estudiantes](https://github.com/user-attachments/assets/2a5cc1b2-898b-4cf0-b657-40048c3e414a)

# E-commerce Platform

Este proyecto es una plataforma de comercio electrónico que incluye varios microservicios. Los servicios están diseñados para trabajar en conjunto dentro de un proyecto padre llamado `ecommerce-platform`. Los microservicios incluidos son:

- **API Gateway**
- **Order Service**
- **Product Service**

## Requisitos Previos

Antes de ejecutar la aplicación, asegúrate de tener instalados los siguientes programas:

- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven 3.6+](https://maven.apache.org/install.html)
- [PostgreSQL 12+](https://www.postgresql.org/download/)
- [Docker](https://www.docker.com/get-started) (opcional para una ejecución rápida con contenedores)

## Configuración de la Base de Datos

Se requiere una base de datos **PostgreSQL** para ejecutar los microservicios. A continuación se muestran los pasos para configurarla:

1. **Crear una base de datos para Order Service**:
   ```sql
   CREATE DATABASE orderdb;
   ## Pruebas de los Endpoints

Las pruebas de los endpoints se realizan a través de **Swagger UI** en la siguiente dirección:  
[http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)
