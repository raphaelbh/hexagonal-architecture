#!/bin/bash

echo "########### Create table (Transactions) ###########"
aws dynamodb create-table \
    --endpoint-url http://localhost:4566 \
    --table-name Transactions \
    --attribute-definitions AttributeName=user,AttributeType=S AttributeName=transaction_id,AttributeType=S \
    --key-schema AttributeName=user,KeyType=HASH AttributeName=transaction_id,KeyType=RANGE \
    --billing-mode PAY_PER_REQUEST