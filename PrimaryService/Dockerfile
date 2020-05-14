FROM openjdk:8-jdk-alpine
ADD target/PrimaryService-0.0.1-SNAPSHOT.jar prim.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "prim.jar"]