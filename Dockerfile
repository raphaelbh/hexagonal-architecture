FROM openjdk:latest

WORKDIR /application

COPY ./application /application

RUN ./gradlew clean build

ENV SPRING_PROFILES_ACTIVE=docker
CMD ["java", "-jar", "build/libs/bank-0.0.1-SNAPSHOT.jar"]