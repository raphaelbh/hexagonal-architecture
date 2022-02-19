package br.com.raphaeloliveira.bank.adapters.out.datasource.dynamodb

import aws.sdk.kotlin.services.dynamodb.model.AttributeValue
import br.com.raphaeloliveira.bank.domain.models.Transaction
import br.com.raphaeloliveira.bank.domain.ports.out.TransactionsDatasourcePort
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TransactionsDatasourceAdapter(
    private val transactionRepository: TransactionRepository): TransactionsDatasourcePort {

    override fun saveTransaction(transaction: Transaction) {
        transactionRepository.save(transaction)
    }

    override fun getTransactions(user: String, date: LocalDate): List<Transaction> {
        val items = transactionRepository.query(user, date) ?: return ArrayList()
        return items.map {
            Transaction(
                (it["transaction_id"] as AttributeValue.S).value,
                (it["user"] as AttributeValue.S).value,
                LocalDate.parse((it["date"] as AttributeValue.S).value),
                (it["amount"] as AttributeValue.N).value.toDouble(),
                (it["description"] as AttributeValue.S).value)
        }
    }
}