FROM openjdk:latest
COPY app/build/libs/bank-0.0.1-SNAPSHOT.jar bank-0.0.1-SNAPSHOT.jar.jar
ENTRYPOINT ["java","-jar","bank-0.0.1-SNAPSHOT.jar.jar"]