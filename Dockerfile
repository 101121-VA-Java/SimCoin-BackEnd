FROM openjdk:8-jdk-alpine
COPY target/SimCoin.jar  SimCoin.jar
ENTRYPOINT ["java", "-jar", "/SimCoin.jar"]