


![Arquitectura microservicio estudiantes](https://github.com/user-attachments/assets/2a5cc1b2-898b-4cf0-b657-40048c3e414a)

# E-commerce Platform

Este proyecto es una plataforma de comercio electrónico que incluye varios microservicios. Los servicios están diseñados para trabajar en conjunto dentro de un proyecto padre llamado `ecommerce-platform`. Los microservicios incluidos son:

- **API Gateway**
- **Order Service**
- **Product Service**
- **Base de datos PostgreSQL** (para cada servicio)

## Requisitos Previos

Antes de ejecutar la aplicación, asegúrate de tener instalados los siguientes programas:

- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven 3.6+](https://maven.apache.org/install.html)
- [PostgreSQL 12+](https://www.postgresql.org/download/)
- [Docker](https://www.docker.com/get-started) (opcional para una ejecución rápida con contenedores)

## Instrucciones para Ejecutar los Servicios
- Paso 1: Clonar el Repositorio 

Clona este repositorio en tu máquina local.
https://github.com/devpcarlos/Linktic.git

git clone [URL_DEL_REPOSITORIO]

cd [NOMBRE_DEL_REPOSITORIO]

- Paso 2: Construir y Ejecutar los Contenedores

Navega a la raíz del proyecto donde se encuentra el archivo docker-compose.yml y ejecuta el siguiente comando:

docker-compose up --build

Este comando realizará lo siguiente:

- Construirá las imágenes de Docker para order-service y product-service en sus servicios.
- Iniciará los contenedores y enlazará los puertos especificados.
- Para la api-gateway, una vez que los otros servicios estén corriendo, ve a la carpeta del api-gateway y construye su imagen usando su Dockerfile:
  docker build -t api-gateway .
  Esto creará la imagen del api-gateway a partir del Dockerfile.

Luego, ejecuta el contenedor del api-gateway con el siguiente comando:
docker run -p 8080:8080 --name api-gateway --network="host" api-gateway


Las pruebas de los endpoints se realizan a través de **Swagger UI** en la siguiente dirección:  
- Para **Order Service**: [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)

- Para **Product Service**:[http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
