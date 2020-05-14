FROM openjdk:8-jdk-alpine
ADD target/EurekaServer-0.0.1-SNAPSHOT.jar eureka.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka.jar"]