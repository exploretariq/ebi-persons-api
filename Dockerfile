FROM maven:3.5.2-jdk-8-alpine AS build
COPY pom.xml /tmp/pom.xml
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package
 
FROM java:8-jdk-alpine
COPY --from=build /tmp/target/persons-api-0.0.1-SNAPSHOT.jar /usr/app/persons-api-0.0.1-SNAPSHOT.jar
WORKDIR /usr/app
RUN sh -c 'touch persons-api-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","persons-api-0.0.1-SNAPSHOT.jar"]