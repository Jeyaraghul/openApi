FROM maven:3.8-openjdk-11 as build
WORKDIR /app
COPY . .
RUN mvn install

FROM fabric8/java-alpine-openjdk11-jre
WORKDIR /app
COPY --from=build /app/target/OpenAPI-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080

CMD ["java", "-jar" ,"app.jar"]