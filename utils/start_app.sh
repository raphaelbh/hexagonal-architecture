#!/bin/bash

SCRIPT_PATH=`readlink -f "$0"`
SCRIPT_DIR=`dirname "$SCRIPT_PATH"`

# build app
(cd $SCRIPT_DIR/../app && rm -R build && ./gradlew build)

# start app
java -jar $SCRIPT_DIR/../app/build/libs/bank-0.0.1-SNAPSHOT.jar
