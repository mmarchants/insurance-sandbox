# Sandbox project

[//]: # ([![Build Status]&#40;https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master&#41;]&#40;https://travis-ci.org/codecentric/springboot-sample-app&#41;)

[//]: # ([![Coverage Status]&#40;https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master&#41;]&#40;https://coveralls.io/github/codecentric/springboot-sample-app?branch=master&#41;)

[//]: # ([![License]&#40;http://img.shields.io/:license-apache-blue.svg&#41;]&#40;http://www.apache.org/licenses/LICENSE-2.0.html&#41;)

Sandbox project made with [Spring Boot](https://spring.io/projects/spring-boot) framework to apply and test latest Java features and good coding practices.

### Requirements

For building and running the application you need:

- [JDK 21](https://openjdk.org/projects/jdk/21/) (via [SDKMAN!](https://sdkman.io/http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
- [Maven 3](https://maven.apache.org)
- [PostgreSQL](https://www.postgresql.org/download/)
  - After instaling, you need to create a DB for the application to use:
    ```shell
    psql -U postgres
    ```
  - Then, create a new database and specify the default user as owner:
    ```shell
    postgres=# CREATE DATABASE sandbox OWNER postgres;
    ```  
### Running the application locally

There are multiple ways to run the application on your local machine. One way is to execute the `main` method in the `com.sandbox.InsuranceApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

### Using the application

To interact with the application you can use the REST API through a [Postman](https://www.postman.com/) collection found inside the project root folder with sample operations.

Also, a [Swagger](https://swagger.io/) API specification UI can be explored navigating to:

```
http://localhost:8080/swagger-ui/index.html
```

## Acknowledgments

* All written code is self made

* No code was taken from private repositories

## To Do:
* Add Endpoint pagination (@Pageable).
* Add cache to endpoints and make sure to keep cache updated if records are deleted.
* Update readme with dependencies, how to run, how to test and a brief description.
* ~~Create local postgres DB.~~
* Connect to 3rd party for address validation (USPS using RestTemplates/Webflux & use versioning e.g. v1/resttemplates).
* Future: 
  * Add another 3rd party integration with gRPC.
  * Connect with AWS: QueueListener, Store data on S3.
  * CI/CD.


## Author

* **Mariano Marchant** - *Senior Java Developer* - [GitHub](https://github.com/mmarchants)
