FROM openjdk:8-jdk-alpine
ADD target/secondaryService-0.0.1-SNAPSHOT.jar secondary.jar
EXPOSE 7071
ENTRYPOINT ["java", "-jar", "secondary.jar"]