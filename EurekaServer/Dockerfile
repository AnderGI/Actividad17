FROM openjdk:23-slim-bullseye
VOLUME /tmp
ADD ./target/EurekaServer-0.0.1-SNAPSHOT.jar eureka-ms.jar
ENTRYPOINT ["java","-jar","eureka-ms.jar"]
#CMD java -jar productos-ms.jar