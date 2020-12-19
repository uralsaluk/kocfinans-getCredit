FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/kocfinans-getCredit-1.0.0.jar
WORKDIR /opt/app
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","application.jar"]
