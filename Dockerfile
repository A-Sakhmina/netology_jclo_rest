FROM openjdk:8-jdk-alpine

EXPOSE 8080

COPY target/spring_rest_auth_service-0.0.1-SNAPSHOT.jar rest_app.jar

CMD ["java", "-jar", "rest_app.jar"]




