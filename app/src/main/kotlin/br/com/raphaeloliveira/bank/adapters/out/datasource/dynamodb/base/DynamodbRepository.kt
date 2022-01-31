package br.com.raphaeloliveira.bank.adapters.out.datasource.dynamodb.base

import aws.sdk.kotlin.services.dynamodb.DynamoDbClient
import aws.sdk.kotlin.services.dynamodb.model.AttributeValue
import aws.sdk.kotlin.services.dynamodb.model.QueryRequest
import aws.sdk.kotlin.services.dynamodb.model.QueryResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
abstract class DynamodbRepository: Dynamodb {

    @Autowired
    private lateinit var dynamoDbClient: DynamoDbClient

    suspend fun save(itemValues: Map<String, AttributeValue>) {
        dynamoDbClient.putItem {
            tableName = tableName()
            item = itemValues
        }
    }

    suspend fun query(partitionKey: String): QueryResponse {
        val request = QueryRequest {
            tableName = tableName()
            keyConditionExpression = "#partitionKey = :${partitionKey()}"
            expressionAttributeNames = mutableMapOf("#partitionKey" to partitionKey())
            this.expressionAttributeValues = mutableMapOf(":${partitionKey()}" to AttributeValue.S(partitionKey))
        }
        return dynamoDbClient.query(request)
    }
}