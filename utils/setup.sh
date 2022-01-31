#!/bin/bash

SCRIPT_PATH=`readlink -f "$0"`
SCRIPT_DIR=`dirname "$SCRIPT_PATH"`

# start dynamodb container
(cd $SCRIPT_DIR/../docker && docker-compose up -d)

# check if dynamodb-local is running
if [ $( docker ps -a -f name=dynamodb-local | wc -l ) -eq 2 ]; then
  echo "dynamodb-local running"
else
  echo "dynamodb-local does not running"
  exit
fi

# create dynamodb
aws dynamodb create-table \
    --table-name Transactions \
    --attribute-definitions AttributeName=user,AttributeType=S AttributeName=transaction_id,AttributeType=S \
    --key-schema AttributeName=user,KeyType=HASH AttributeName=transaction_id,KeyType=RANGE \
    --billing-mode PAY_PER_REQUEST \
    --endpoint-url http://localhost:8000 2>/dev/null