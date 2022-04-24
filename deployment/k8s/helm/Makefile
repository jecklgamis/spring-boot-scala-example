APP_NAME:=spring-boot-scala-example
VERSION:=$(shell cat spring-boot-scala-example/Chart.yaml | yq .appVersion)
HELM_CHART=$(APP_NAME)-$(VERSION).tgz

default:
	@cat ./Makefile
package:
	rm -f $(HELM_CHART)
	helm package ./$(APP_NAME)
dry-run:
	@helm install --dry-run --debug $(APP_NAME) ./$(APP_NAME) | tee dry-run.txt
install: package
	@echo $(VERSION)
	@helm install $(APP_NAME) $(HELM_CHART)
uninstall:
	@helm uninstall $(APP_NAME)
upgrade: package
	@helm upgrade $(APP_NAME) $(HELM_CHART)
rollback:
	@helm rollback $(APP_NAME)
clean:
	@rm 0f $(HELM_CHART)
all: package
