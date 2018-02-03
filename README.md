## SpringBoot Scala Example

[![Build Status](https://travis-ci.org/jecklgamis/springboot-scala-example.svg?branch=master)](https://travis-ci.org/jecklgamis/springboot-scala-example)

This is an example SpringBoot app using Scala. This uses the Jetty container.


## Running The App
```
mvn clean package
java -jar target/springboot-scala-example.jar
```

## Running The App In Docker

```
mvn clean package
docker build -t springboot-scala-example .
docker run springboot-scala-example
```


## Testing The Endpoints
Point your browser to `http://localhost:8080` or use `curl` in command line.

```
curl -v  http://localhost:8080/
```

## JSON/XML Serialization Examples

GET JSON response
```
curl -v -H "Accept:application/json" http://localhost:8080/user/some-id
```

GET XML response
```
curl -v -H "Accept:application/xml" http://localhost:8080/user/some-id
```

PUT JSON request
```
curl -v  -X PUT  -H "Content-Type:application/json"  http://localhost:8080/user -d'{"username":"user","email":"user@example.com"}'
```

PUT XML request
```
curl -v  -X PUT  -H "Content-Type:application/xml"  http://localhost:8080/user -d'<?xml version="1.0" encoding="UTF-8" standalone="yes"?><user><username>me</username><email>me@example.com</email></user>'
```

## Makefile
A wrapper Makefile can save some keystrokes. Type `make dist image run` to build and run the app in Docker.

Have fun!


