# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Spring Boot application written in Scala 3. Dual build support with Maven (primary) and SBT (alternative).

**Tech Stack**: Java 21, Scala 3, Spring Boot 3.4.x, Jetty, JUnit 5

## Build Commands

```bash
# Full build (generates build-info, keystore, jar, Docker image)
make all

# Maven build only
./mvnw clean verify

# Run tests
./mvnw test

# Run single test class (Maven)
./mvnw test -Dtest=RootControllerTest

# SBT build
sbt assembly

# SBT tests
sbt test

# Run locally with Docker
make run

# Run locally with jar
java -jar target/spring-boot-scala-example.jar
```

## Architecture

### Source Layout
- `src/main/scala/spring/boot/scala/example/` - Main application code
  - `ExampleApp.scala` - Entry point (`@SpringBootApplication`)
  - `controller/` - REST controllers (Root, BuildInfo, Probe)
  - `ObjectMapperCustomizer.scala` - Jackson configuration for Scala support

### Configuration
- `application.yml` - Default config (port 8080)
- `application-prod.yml` - Production profile (port 8443, HTTPS with self-signed cert)

### Tests
Tests extend `BaseAppTest` which provides Spring Boot integration test setup with `TestRestTemplate` and random port assignment. Located in `src/test/scala/spring/boot/scala/example/controller/`.

### Endpoints
```
GET /              - Root (app name and status)
GET /buildInfo     - Build metadata
GET /probe/live    - Kubernetes liveness
GET /probe/ready   - Kubernetes readiness
GET /actuator/*    - Spring Boot actuator (health, metrics)
```

### Build Scripts
- `generate-build-info.sh` - Creates `src/main/resources/build-info.json` with git metadata
- `generate-keystore.sh` - Creates self-signed SSL certificate for HTTPS

### Deployment
Kubernetes/Helm charts in `deployment/k8s/helm/`. Install with `cd deployment/k8s/helm && make install`.
