FROM openjdk:23-slim-bullseye
VOLUME /tmp
ADD ./target/Alumnos-0.0.1-SNAPSHOT.jar alumnos.jar
ENTRYPOINT ["java","-jar","alumnos.jar"]
#CMD java -jar productos-ms.jar