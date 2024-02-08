# Spring boot microservices architecture template

## What is being used

    - Microservices
    - Eureka Server
    - Spring Cloud Gateway
    - Docker containers
    - Docker networks
    - Docker-compose
   
> ## Docker compose template file
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

