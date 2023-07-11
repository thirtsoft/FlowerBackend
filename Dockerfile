FROM openjdk:8
MAINTAINER tairou
VOLUME /tmp
COPY target/FlowerBackend-0.0.1-SNAPSHOT.war flowerbackend.war
COPY src/main/resources/application.properties application.properties
EXPOSE 8081
ENTRYPOINT ["java","-Xms500m","-Xmx1000m","-war","/flowerbackend.war"]