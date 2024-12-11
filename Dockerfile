FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY build/libs/perfomance-check.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080