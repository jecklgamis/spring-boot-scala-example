# Spring Boot Scala Example

[![Build](https://github.com/jecklgamis/spring-boot-scala-example/actions/workflows/build.yml/badge.svg)](https://github.com/jecklgamis/spring-boot-scala-example/actions/workflows/build.yml)

This is an example Spring Boot app using Scala.

Docker run:
```
docker run -p 8080:8080 jecklgamis/spring-boot-scala-example:latest
```

What's In the Box?

* Scala 3
* Maven and SBT build
* Ubuntu Docker image
* Jetty web container
* HTTPS listener (prod profile) using self-signed certs
* JUnit5 tests
* Actuator endpoints (health, metrics)
* Build info, liveness and readiness probe endpoints
* Example Kubernetes deployment

This is a **Github Template** project. You can create a copy of this project from a clean slate. Simply click
<kbd>Use this template</kbd> button.

## Building
Ensure you have Java 8, Docker, and Make installed.

```
make all
```
This will create build info, keystore, executable jar, and Docker image in one go. Explore the `Makefile` for details.

## Running

Run using Docker:
```bash
make run
```

Run using executable jar:
```bash
java -jar target/spring-boot-scala-example.jar
```

## Endpoints
Point your browser to the urls below or use `curl` in command line.
```bash
curl http://localhost:8080/
curl http://localhost:8080/buildInfo
curl http://localhost:8080/probe/live
curl http://localhost:8080/probe/ready
curl http://localhost:8080/actuor/metrics
curl http://localhost:8080/actuor/health
```
or you can run `./smoke-tests.sh`

## Building With [SBT](https://www.scala-sbt.org/)

Ensure you have SBT installed.

Mac OS:
```bash
brew install sbt
```

Build executable jar:
```bash
sbt assembly
```

Run main class:
```bash
sbt run
```

To build interactively, enter the SBT shell by typing `sbt`. You should then
be able to compile, test,  assemble, or run any other `sbt` commands.

## Deploying To Kubernetes
In this example, the Docker image is built locally and pushed to Docker Hub.

Assumptions:
* You have access to a Kubernetes cluster and can pull image from Docker Hub
* You can push to a Docker registry (Docker Hub in this case)
* You have Python 3 installed. This is used to generate versioned Kubernetes deployment file

Install Python 3 in Mac OS:
```bash
brew install python@3
pip3 install jinja2
```

Build and push Docker image:
```bash
make all push
```

Create a deployment file:
```bash
cd deployment/k8s && ./create-k8s-files.py --version $(git rev-parse HEAD)
```

Deploy:
```bash
kubectl apply -f deployment/k8s/deployment-$(git rev-parse HEAD).yaml
```

If all goes well, you should be able to see your pod using `kubectl get pods`

Delete:
```bash
kubectl delete -f deployment/k8s/deployment-$(git rev-parse HEAD).yaml
```

TIP: `make deploy` does all these commands in one go. 

## Contributing
Please raise issue or pull request! Thanks!