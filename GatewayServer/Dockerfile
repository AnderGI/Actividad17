FROM openjdk:23-slim-bullseye
VOLUME /tmp
ADD ./target/GatewayServer-0.0.1-SNAPSHOT.jar gateway-server.jar
ENTRYPOINT ["java","-jar","gateway-server.jar"]
#CMD java -jar productos-ms.jar