FROM openjdk:17-jdk-slim-buster
ADD target/spring-security-0.0.1-SNAPSHOT.jar spring-security-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "sh" , "-c" , "java -jar spring-security-0.0.1-SNAPSHOT.jar" ]