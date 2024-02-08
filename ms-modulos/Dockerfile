FROM openjdk:23-slim-bullseye
VOLUME /tmp
ADD ./target/Modulos-0.0.1-SNAPSHOT.jar modulos.jar
ENTRYPOINT ["java","-jar","modulos.jar"]
#CMD java -jar productos-ms.jar