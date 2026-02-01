IMAGE_NAME := jecklgamis/spring-boot-scala-example
IMAGE_TAG := latest

.PHONY: default dist image run run-bash build-info keystore chart all up

default:
	@cat ./Makefile

dist: build-info keystore
	./mvnw -Dmaven.artifact.threads=8 -T 1C clean verify

image: dist
	docker build -t $(IMAGE_NAME):$(IMAGE_TAG) .

run:
	docker run -p 8080:8080 -p 8443:8443 $(IMAGE_NAME):$(IMAGE_TAG)

run-bash:
	docker run -i -t $(IMAGE_NAME):$(IMAGE_TAG) /bin/bash

build-info:
	@./generate-build-info.sh

keystore:
	@./generate-keystore.sh

chart:
	cd deployment/k8s/helm && make package

all: image

up: all run
