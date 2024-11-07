# lets use OpenJDK docker image
FROM gradle:jdk11-alpine AS builder
COPY --chown=gradle:gradle . /code
WORKDIR /code
RUN gradle build -x test
RUN ls -R build

FROM openjdk:18-ea-11-alpine3.15
EXPOSE 8081
VOLUME /tmp
ARG targethost=localhost:8080
ENV API_HOST=$targethost
ARG LIBS=/code/build/libs
RUN mkdir /app
COPY --from=builder ${LIBS}/ /app
# deploy the jar file to the container
ENTRYPOINT ["java", "-jar", "./app/authentication-0.0.1-SNAPSHOT.jar"]
