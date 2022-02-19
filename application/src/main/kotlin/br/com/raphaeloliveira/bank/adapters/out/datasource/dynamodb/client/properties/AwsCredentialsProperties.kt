package br.com.raphaeloliveira.bank.adapters.out.datasource.dynamodb.client.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "cloud.aws.credentials")
data class AwsCredentialsProperties(val accessKey: String, val secretKey: String)
