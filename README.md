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
curl http://localhost:8080/actuator/metrics
curl http://localhost:8080/actuator/health
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
Assumptions:
* You have `helm`command installed (Mac OS: `brew install helm`)
* You can deploy to a Kubernetes cluster that can access Docker Hub 

Build and install Helm chart:
```bash
cd deployment/k8s/helm
make install 
```
This creates:
* a service account
* a pod running on port 8080
* a service listening on port 80 (and implicitly Endpoint resources corresponding to the number of pods)
* a deployment (and implicitly replicaset)
* an ingress for Istio (assumes you have Istio installed in your cluster) 

Use this command to verify if the app is running: 
````
curl -v -H "Host:spring-boot-scala-example.local" http://<your-ingress-load-balancer-hostname>
````
You can use a dedicated DNS for your app. Change `spring-boot-scala-example.local` in ingress section in `values.yaml`, 
ensure it points to your ingress load balancer, and deploy the chart with `make upgrade`

If you are using Nginx ingress controller, simply switch `kubernetes.io/ingress.class` to nginx in the `values.yaml` 
and redeploy.

## Contributing
Please raise issue or pull request! Thanks!