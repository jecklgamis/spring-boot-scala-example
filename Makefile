IMAGE_NAME:=jecklgamis/spring-boot-scala-example
IMAGE_TAG:=latest

default:
	@cat ./Makefile
dist: keystore build-info
	./mvnw -Dmaven.artifact.threads=8 -T 1C clean verify
image:
	docker build -t $(IMAGE_NAME):$(IMAGE_TAG) .
run:
	docker run -p 8080:8080  -p 8443:8443 $(IMAGE_NAME):$(IMAGE_TAG)
run-bash:
	docker run -i -t $(IMAGE_NAME):$(IMAGE_TAG) /bin/bash
build-info:
	@./generate-build-info.sh
keystore:
	@./generate-keystore.sh
chart:
	cd deployment/k8s/helm && make package
all: dist image chart
up: all run
