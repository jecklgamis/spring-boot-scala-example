APP_NAME:=spring-boot-scala-example
VERSION:=$(shell cat chart/Chart.yaml | yq .appVersion)
HELM_CHART=$(APP_NAME)-$(VERSION).tgz

default:
	@cat ./Makefile
package:
	@rm -f $(HELM_CHART)
	helm package ./chart
dry-run:
	@helm install --dry-run --debug $(APP_NAME) ./chart | tee dry-run.txt
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
	@rm -f $(HELM_CHART)
all: package
