FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/myapp.jar myapp.jar

EXPOSE 8090

ENTERYPOINT ["java", "-jar", "myapp.jar"]