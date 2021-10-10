IMAGE_NAME:=jecklgamis/spring-boot-scala-example
IMAGE_TAG:=$(shell git rev-parse HEAD)

default:
	@cat ./Makefile
dist: keystore build-info
	./mvnw -Dmaven.artifact.threads=8 -T 1C clean verify
image:
	docker build -t $(IMAGE_NAME):$(IMAGE_TAG) -t $(IMAGE_NAME):latest .
run:
	docker run -p 8080:8080  -p 8443:8443 $(IMAGE_NAME):$(IMAGE_TAG)
run-bash:
	docker run -i -t $(IMAGE_NAME):$(IMAGE_TAG) /bin/bash
build-info:
	@./generate-build-info.sh
keystore:
	@./generate-keystore.sh
all: dist image
up: all run
push:
	 docker push $(IMAGE_NAME):$(IMAGE_TAG)
	 docker push $(IMAGE_NAME):latest
tag:
	 git tag -m "spring-boot-scala-example-v$(IMAGE_TAG)" -a "v$(IMAGE_TAG)"
	 git push --tags
deploy: dist image push
	cd deployment/k8s && ./create-k8s-files.py --version $(IMAGE_TAG)
	kubectl apply -f deployment/k8s/deployment-$(IMAGE_TAG).yaml
undeploy:
	cd deployment/k8s && ./create-k8s-files.py --version $(IMAGE_TAG)
	kubectl delete -f deployment/k8s/deployment-$(IMAGE_TAG).yaml

