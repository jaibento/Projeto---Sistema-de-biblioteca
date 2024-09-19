# Dockerfile para a aplicação Spring Boot
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/library-app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
