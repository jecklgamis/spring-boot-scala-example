#!/usr/bin/env bash

declare -a urls=(
  "http://localhost:8080/"
  "http://localhost:8080/buildInfo"
  "http://localhost:8080/probe/live"
  "http://localhost:8080/probe/ready"
  "http://localhost:8080/actuator/metrics"
  "http://localhost:8080/actuator/beans"
  )

exit_code=0
for url in "${urls[@]}"; do
  result=$(curl -o /dev/null -s -w "%{http_code}" "$url")
  if [ "${result}" == "200" ]; then
    echo "${url} OK";
  else
    echo "${url} NG (${result})";
    exit_code=1
  fi
done

exit ${exit_code}