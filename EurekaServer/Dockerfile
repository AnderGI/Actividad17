FROM openjdk:17
VOLUME /tmp
ADD ./target/EurekaServer-0.0.1-SNAPSHOT.jar eureka.jar
ENTRYPOINT ["java","-jar","eureka.jar"]