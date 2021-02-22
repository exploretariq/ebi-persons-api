FROM java:8-jdk-alpine

COPY ./target/persons-api-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch persons-api-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","persons-api-0.0.1-SNAPSHOT.jar"]