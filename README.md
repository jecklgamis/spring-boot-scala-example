## Spring Boot Scala Example

[![Build](https://github.com/jecklgamis/spring-boot-scala-example/actions/workflows/build.yml/badge.svg)](https://github.com/jecklgamis/spring-boot-scala-example/actions/workflows/build.yml)

This is an example Spring Boot app using Scala. 

* Uses Jetty web container
* Starts HTTP and HTTPs listener 
* Enables some actuator endpoints (health, metrics)

This is a **Github Template** project. You can create a copy of this project from a clean slate. Simply click
<kbd>Use this template</kbd> button.

## Running The App
Ensure you have Java 8 or later.
```
./generate-keystore.sh
./mvnw clean package
java -jar target/spring-boot-scala-example.jar
```

## Running The App Using Docker
Ensure you have a working Docker environment.
```
make dist image run
```

## Testing The Endpoints
Point your browser to `http://localhost:8080` or use `curl` in command line.

```
curl -v  http://localhost:8080/
curl -v -k https://localhost:8443/
```
Actuator endpoints:
* `http://localhost:8080/actuator/metrics`
* `http://localhost:8080/actuator/health`


