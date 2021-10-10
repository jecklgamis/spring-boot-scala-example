#!/usr/bin/env bash

BRANCH=$(git rev-parse --abbrev-ref HEAD)
VERSION=$(git rev-parse HEAD)
BUILD_TIME=$(date +"%Y-%m-%dT%H:%M:%S%z")
BUILD_INFO_FILE=./src/main/resources/build-info.json

cat <<EOF > ${BUILD_INFO_FILE}
{ "branch": "${BRANCH}",  "build-time": "${BUILD_TIME}",  "version": "${VERSION}" }
EOF

echo "Wrote $BUILD_INFO_FILE" && cat ${BUILD_INFO_FILE}
