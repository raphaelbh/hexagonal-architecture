package br.com.raphaeloliveira.bank.adapters.out.datasource.dynamodb.client.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "cloud.dynamodb")
data class DynamodbProperties(val region: String, val endpoint: String)
