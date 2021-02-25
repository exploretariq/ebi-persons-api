# Persons API

[![Build Status](https://travis-ci.com/exploretariq/ebi-persons-api.svg?branch=master)](https://travis-ci.com/exploretariq/ebi-persons-api)

Persons API is a small spring boot micro service based project which exposes CRUD endpoints.

## 1. Build and Deployment Instructions

### 1.1. Local Build and Deployment

Persons api requires [Docker](https://docs.docker.com/engine/install/) and [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) to be installed locally. 

```sh
mkdir workspace
cd workspace
git clone https://github.com/exploretariq/ebi-persons-api.git
docker build -t persons-api .
```

The following commands will deploy the persons-api as a single container in the port 8080. Feel free to change the port by replacing **8080:8080** with **{yourport}:8080**

```sh
docker run -p 8080:8080 persons-api 
docker ps
```
If you want to deploy the api with **scaling** and **loadbalancing** factor on. **No need to run the above 2 lines.** Instead run the following command. This will spin up three instances and the load balancer will listen to the port **8090**. You can change the port configurations in [nginx](https://github.com/exploretariq/ebi-persons-api/blob/master/nginx.conf) and [docker-compose](https://github.com/exploretariq/ebi-persons-api/blob/master/docker-compose.yml) 

```sh
docker-compose up --scale persons-api=3
docker ps
```

### 1.2. Deploy locally with the existing CICD build 

You can find the existing docker image [here](https://hub.docker.com/repository/docker/tariqsulaiman/ebi-persons-api) which is coming from the CICD process [here](https://travis-ci.com/exploretariq/ebi-persons-api)

```sh
docker pull tariqsulaiman/ebi-persons-api
docker run -p 8080:8080 tariqsulaiman/ebi-persons-api
docker ps
```
### 1.3. Hosted Application with CICD

An application is already deployed in heroku environment with the CICD [process](https://travis-ci.com/exploretariq/ebi-persons-api). 

1. You can access the application **API docs** [here](https://ebi-persons-api.herokuapp.com/ebi/swagger-ui/)
2. You can see the **code coverage** [here](https://codecov.io/gh/exploretariq/ebi-persons-api)

## 2. Testing the application

[Postman](https://www.postman.com/downloads/) can be used for testing the persons-api application extensively. Import the postman [collection](https://www.getpostman.com/collections/0bbb6cce4df1fa5f4787). Create 2 environments in the postman(local and heroku) and define the variable **EBI_PERSONS_API** as **localhost:8080** for local env and as **https://ebi-persons-api.herokuapp.com** for heroku environment.

Once the setup is done. Please read the API documentation of persons [here](https://ebi-persons-api.herokuapp.com/ebi/swagger-ui/#/person-controller).

Since the entire application is **secured with JWT token**, you will not be able to invoke person endpoints from the postman. Please follow the steps below for extensive testing.

1. Invoke Signup User endpoint from the collection. This will create a registered user in the system.
```sh
curl --location --request POST 'https://ebi-persons-api.herokuapp.com/ebi/users/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "ebi",
    "password": "ebi123"
}'
```
2. Invoke User Login endpoint from the collection. This will return Authorization Bearer token in the header response.
```sh
curl --location --request POST 'https://ebi-persons-api.herokuapp.com/ebi/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "ebi",
    "password": "ebi123"
}'
```
3. Use this Bearer token in the Authorization Header of any CRUD endpoints of Person.
```sh
curl --location --request POST 'https://ebi-persons-api.herokuapp.com/ebi/persons' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJlYmkiLCJleHAiOjE2MTQyNzc3NzB9.eOE853zVkT7i5SmuNBJrj0Dp9XVUMS6W4xzaEBBoz6Cht10BaQ6WEEFe3PA2ZPB7IClu16tEvI9z5KySrxOviw' \
--header 'Content-Type: application/json' \
--data-raw '{
    "first_name": "Sarah",
    "last_name": "Robinson", 
    "age": "36", 
    "favourite_colour": "blue"
}'
```
    
## 3. Features

### 3.1. Scalability

The persons api is capabale of horizontal scaling which uses the docker compose feature. The details are mentioned in the deployment section.

### 3.2. Loadbalancing

There is a very basic Nginx load balancer capabale of distributing the API load. The details are mentioned in the deployment section.

### 3.3. CICD Integration

The application is CICD integrated end to end starting from git commits to Heroku deployment.

![alt text](https://github.com/exploretariq/ebi-persons-api/Ebi-persons-cicd.png.jpg?raw=true)

The tools used are [github](https://github.com/), [travis](https://travis-ci.com/), [docker](https://hub.docker.com/), [maven](https://maven.apache.org/), [codecov](https://codecov.io/) and [heroku](https://www.heroku.com/).


### 3.4. Swagger API Documentation
You can access the application **API docs** [here](https://ebi-persons-api.herokuapp.com/ebi/swagger-ui/)

### 3.5. In Memory Database support

H2 In memory Embedded Data base is used for the DB operations. You can find the h2 console [here](https://ebi-persons-api.herokuapp.com/ebi/h2-console). 

### 3.6. Effective Search API

The code base is generic enough to handle effective search operation based on RSQL parsing.
Also pagination and sorting is supported. Please refer **Get Persons - Age & First Name filter** endpoint in the postman collection for more details on this
```sh
curl --location --request GET 'https://ebi-persons-api.herokuapp.com/ebi/persons?search=firstName==Sarah;age%3E=20&page=0&size=2' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJlYmkiLCJleHAiOjE2MTQyNzc3NzB9.eOE853zVkT7i5SmuNBJrj0Dp9XVUMS6W4xzaEBBoz6Cht10BaQ6WEEFe3PA2ZPB7IClu16tEvI9z5KySrxOviw'
```

### 3.7. Effective Add Persons batch API

Add multiple persons is supported with batch insert on DB.

### 3.8. Spring Security

The application is integrated with Spring security providing the basic authentication using expiring **JWT Bearer tokens**.

### 3.9. Application Monitoring with Actuators

The application health and other metrics can be monitored using Spring actuators. The documetnation is available [here](https://ebi-persons-api.herokuapp.com/ebi/swagger-ui/#/operation-handler). A sample endpoint name in the postman is **Check Application Metrics**

### 3.10. Dynamic log level configuration.

Used spring boot actuators to dynamically confiure log levels for the application without down time. The endpoint for the same in the postman is **Configure Log Levels**

```sh
curl --location --request POST 'https://ebi-persons-api.herokuapp.com/ebi/actuator/loggers/com.ebi.person' \
--header 'Content-Type: application/json' \
--data-raw '{"configuredLevel": "INFO"}'
```

### 3.11. Minimized code vulnerabilty 

Usage of frameworks wherever applicable. This would reduce code vulnerabilty. Example : Usage of spring data would remove vulnerabilty attacks like SQL injection.

### 3.12. Unit testing

Proper Unit testing for the important components of the app. You can see the coverage report [here](https://codecov.io/gh/exploretariq/ebi-persons-api/tree/master/src/main/java/com/ebi/person)

## 4. Tech & Plugins

Persons api uses a number of open source projects to work properly:

- Java 1.8
- spring boot 2.4.0
- spring fox boot starter 3.0.0
- spring fox swagger ui 3.0.0
- cz jirutka rsql parser 2.1.0
- io json web token jjwt 0.9.1
- h2 database 1.4.200
- junit vintage 5.7.0
- spring-boot-maven-plugin
- jacoco-maven-plugin 0.8.6
- jib-maven-plugin 2.2.0
- heroku-maven-plugin 3.0.2

## 5. Limitations/Work in Progress

1. Authorization is not yet done.
2. JUnit coverage has to be improved
3. Auditing of API operations. 
4. Handle Soft deletes.
5. No API throtting tool
6. DB Connection pooling is not yet done.
7. Integration with code analysis tool like Sonar.
8. Better Java Documentation.
9. Many more!!!!! :)