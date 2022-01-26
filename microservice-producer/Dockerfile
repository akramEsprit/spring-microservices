FROM openjdk:8-jdk-alpine as mvn-build
WORKDIR /app/build
COPY ./src ./src
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN ./mvnw clean install -Dmaven.test.skip=true

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY wait_for_config_server.sh .
COPY --from=mvn-build /app/build/target/*.jar ./spring-app.jar
RUN ["chmod","+x","/app/wait_for_config_server.sh"]
ENTRYPOINT ["/app/wait_for_config_server.sh"]

