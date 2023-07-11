#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/FlowerBackend-0.0.1-SNAPSHOT.war /usr/local/lib/flowerbackend.war
EXPOSE 8092
ENTRYPOINT ["java","-Xms500m","-Xmx1000m","-war","/flowerbackend.war"]