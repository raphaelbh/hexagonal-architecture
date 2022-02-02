#!/bin/bash

# build app
(cd app && rm -f -r -- build && ./gradlew build)

# start app
docker-compose up -d