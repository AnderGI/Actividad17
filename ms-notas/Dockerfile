FROM openjdk:23-slim-bullseye
VOLUME /tmp
ADD ./target/Notas-0.0.1-SNAPSHOT.jar notas.jar
ENTRYPOINT ["java","-jar","notas.jar"]
#CMD java -jar productos-ms.jar