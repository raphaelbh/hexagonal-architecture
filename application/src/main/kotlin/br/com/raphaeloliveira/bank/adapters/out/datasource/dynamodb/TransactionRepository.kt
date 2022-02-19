package br.com.raphaeloliveira.bank.adapters.out.datasource.dynamodb

import aws.sdk.kotlin.services.dynamodb.model.AttributeValue
import br.com.raphaeloliveira.bank.adapters.out.datasource.dynamodb.base.DynamodbRepository
import br.com.raphaeloliveira.bank.domain.models.Transaction
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class TransactionRepository: DynamodbRepository() {

    override fun tableName(): String { return "Transactions" }
    override fun partitionKey(): String { return "user" }

    fun save(transaction: Transaction) {
        val itemValues = mutableMapOf(
            "user" to AttributeValue.S(transaction.user),
            "transaction_id" to AttributeValue.S(transaction.id),
            "date" to AttributeValue.S(transaction.date.toString()),
            "amount" to AttributeValue.N(transaction.amount.toString()),
            "description" to AttributeValue.S(transaction.description))
        runBlocking { save(itemValues) }
    }

    fun query(user: String, date: LocalDate): List<Map<String, AttributeValue>>? =
        runBlocking {
            query(user,"#date = :date", mapOf("#date" to "date"),
                mapOf(":date" to AttributeValue.S(date.toString())))
        }.items
}
