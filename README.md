# Spring boot microservices architecture template

## How to use it
Inside ./production there is a folder which contains the docker-compose.yml the init and dbdata folder. Inside that folder execute
```
docker-compose up
```


## What is being used

    - Microservices
    - Eureka Server
    - Spring Cloud Gateway
    - Docker containers
    - Docker networks
    - Docker-compose
   
## Docker compose template file

### Service download
> [!IMPORTANT]
> All services are downloaded at the same time

### Image rebuilding
> [!IMPORTANT]
> Every time the codebase of any microservice is changed a new image has to be built and pushed to

### Relathionship with application.properties of the microservices
> [!IMPORTANT]
> Container name should be equal to the one in application.properties

### Porst
> [!NOTE]
> External port : Internal port (the one that is being used inside the docker network)

### mysql image
> [!NOTE]
> Create passwd for root user, create sa user and create database (for that database sa user will be granted all permissions)

### Volumes
> [!IMPORTANT]
> Volumes will map our own folders and files inside ./compose with the ones inside the containers
> Init will have executable sql scripts. They will be executed in order.

### Example
```
version: "3.8"
services:
  eureka:
    image: andergi/eureka:latest
    container_name: eureka
    mem_limit: 700m
    ports:
      - "8761:8761"
    networks:
      - "alumnos"
  gateway:
    image: andergi/gateway:latest
    container_name: gateway
    mem_limit: 700m
    ports:
      - "8090:8090"
    depends_on:
      - "eureka"
    deploy:
      restart_policy:
        condition: on-failure
        delay: 5s
        max_attempts: 5
        window: 120s
    networks:
      - "alumnos"
  mysql:
    image: mysql:latest
    container_name: mysql
    environment:
      - MYSQL_ROOT_PASSWORD=tiger
      - MYSQL_DATABASE=alumnos
      - MYSQL_USER=sa
      - MYSQL_PASSWORD=tiger
    volumes:
      - ./init:/docker-entrypoint-initdb.d
      - ./dbdata:/var/lib/mysql
    ports:
      - "3307:3306"
    networks:
      - "alumnos"
  modulos:
    image: andergi/modulos:latest
    container_name: modulos
    mem_limit: 700m
    ports:
      - "8010:8010"
    depends_on:
      - "mysql"
      - "eureka"
    networks:
      - "alumnos"
  alumnos:
    image: andergi/alumnos:latest
    container_name: alumnos
    mem_limit: 700m
    ports:
      - "8005:8005"
    depends_on:
      - "mysql"
      - "eureka"
    deploy:
      restart_policy:
        condition: on-failure
        delay: 5s
        max_attempts: 5
        window: 120s
    networks:
      - "alumnos"
  notas:
    image: andergi/notas:latest
    container_name: notas
    mem_limit: 700m
    ports:
      - "8015:8015"
    depends_on:
      - "mysql"
      - "eureka"
    networks:
      - "alumnos"
networks:
  alumnos:
```
