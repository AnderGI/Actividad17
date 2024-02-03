FROM openjdk:17
VOLUME /tmp
ADD ./target/ms-notas-0.0.1-SNAPSHOT.jar notas-ms.jar
ENTRYPOINT ["java","-jar","notas-ms.jar"]