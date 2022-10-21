# Maven 
FROM maven:3.8.1-openjdk-11-slim AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn clean -e -B package -DskipTests
 
#Java
FROM openjdk:11-jre-slim-buster
EXPOSE 8080
WORKDIR /app
COPY --from=builder /app/target/accounting-service-0.0.1-SNAPSHOT.jar .
#ENTRYPOINT ["java", "-jar", "./accounting-service-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["java",\
"-jar",\
"-Dspring.datasource.url=${SPRING_DATASOURCE_URL}",\
"-Dspring.spring.datasource.username=${SPRING_DATASOURCE_USERNAME}",\
"-Dspring.spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}",\
"-Dspring.datasource.driver-class-name=${SPRING_DATASOURCE_DRIVER_CLASS_NAME}",\
"./accounting-service-0.0.1-SNAPSHOT.jar"]