#!/bin/bash

# start intra
docker-compose up -d

# build app
(cd app && rm -f -r -- build && ./gradlew build)

# start app
java -jar app/build/libs/bank-0.0.1-SNAPSHOT.jar
