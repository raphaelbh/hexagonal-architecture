package br.com.raphaeloliveira.bank.adapters.out.datasource.dynamodb.client

import aws.sdk.kotlin.runtime.auth.credentials.Credentials
import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider
import aws.sdk.kotlin.runtime.endpoint.AwsEndpoint
import aws.sdk.kotlin.runtime.endpoint.StaticEndpointResolver
import aws.sdk.kotlin.services.dynamodb.DynamoDbClient
import br.com.raphaeloliveira.bank.adapters.out.datasource.dynamodb.client.properties.AwsCredentialsProperties
import br.com.raphaeloliveira.bank.adapters.out.datasource.dynamodb.client.properties.DynamodbProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DynamoDbClientConfiguration(
    private val dynamodbProperties: DynamodbProperties,
    private val awsCredentialsProperties: AwsCredentialsProperties
) {

    //https://docs.aws.amazon.com/sdk-for-kotlin/latest/developer-guide/home.html

    @Bean
    fun dynamoDbClient(): DynamoDbClient {
        return DynamoDbClient {
            region = dynamodbProperties.region
            credentialsProvider = StaticCredentialsProvider(
                Credentials(awsCredentialsProperties.accessKey, awsCredentialsProperties.secretKey)
            )
            endpointResolver = StaticEndpointResolver(AwsEndpoint(dynamodbProperties.endpoint))
        }
    }
}