#!/bin/bash
set -ex
cd /usr/local/app
exec java -jar "bin/springboot-scala-example.jar"

