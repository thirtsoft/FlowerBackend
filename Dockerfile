#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11-jdk-slim
MAINTAINER tairou
VOLUME /tmp
COPY target/FlowerBackend-0.0.1-SNAPSHOT.war flowerbackend.war
EXPOSE 8081
ENTRYPOINT ["java","-Xms500m","-Xmx1000m","-war","/flowerbackend.war"]