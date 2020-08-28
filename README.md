# Microservices

## Requisitos
Los mismos utilizados durante el curso
1) Java 8.
2) Maven.
3) Docker compose.

## Cómo compilar el proyecto

En la raíz se encuentra el script `build-jars.sh` . Al ejecutar compilará los módulos del proyecto, para ello se debe ejecutar lo siguiente en la raíz del proyecto

    ./build-jars.sh

## Cómo levantar el proyecto usando docker compose

En la raíz se encuentra el archivos `docker-compose.yml`, para levantar el proyecto se debe ejecutar los siguientes en la raíz del proyecto:

    docker-compose up --build --force-recreate --no-deps
    
Si se quiere volver a construir una sola imagen, ejecutar por ejemplo lo siguiente:
    
    docker-compose up --build --force-recreate --no-deps IMAGEN
    
 ## Balanceo de carga
 El proyecto está preparado para poder levantar multiples instancias del microservicio `kangaroo`. Para eso, con los demás contenedores ya arriba se ejecuta:
 
 ```
 docker-compose scale kangaroo=<numero de instancias que se desean crear>
 
 Ejemplo
 docker-compose scale kangaroo=3
 ```
 Esto creará y levantará multiples instancias de este servicio.
      
## Configuraciones
Las configuraciones leídas por el servidor de configuraciones para cada uno de los módulos se encuentra en este [repo.](https://github.com/mirtagonz/microservices-configurations)

## Urls para acceder a los servicios
1) knowsmore, servidor de configuraciones, se encuentra en: `http://localhost:8888`.
2) gandalf, api gate way, se encuentra en: `http://localhost:8181`.
3) arquimedes, eureka server, se encuentra en: `http://localhost:8761`.
4) golden, se encuentra en: `http://localhost:8080`.
5) kangaroo, se encuentra en: `http://localhost:8090`.

## Pruebas
En la raíz se encuentra un  workspace de insomnia con consultas a los endpoints.

## Comentarios
En este repo se desarrolló solo el perfil dev.
