FROM maven:3.6.3-openjdk-14 AS builder
LABEL maintainer='Lukas Schachner <lukas.schachnerxd@gmail.com'

#copy maven pom for dependency information
COPY \
    ./pom.xml \
    ./pom.xml

#copy source files
COPY \
    ./src \
    ./src

#build project
RUN \
    mvn package --no-transfer-progress

FROM openjdk:8u272-jre-slim-buster

WORKDIR \
    /app

#copy build jar from maven builder
COPY \
    --from=builder \
    target/masterypointbot-*.jar \
    ./app.jar

COPY \
    ./responses/championList.json \
    ./responses/championList.json

#run application
CMD ["java", "-jar", "./app.jar"]