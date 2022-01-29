package br.com.raphaeloliveira.bank.adapters.out.datasource.dynamodb

import br.com.raphaeloliveira.bank.domain.models.Transaction
import br.com.raphaeloliveira.bank.domain.ports.out.TransactionsDatasourcePort
import java.time.LocalDate

class TransactionsDatasourceAdapter: TransactionsDatasourcePort {
    override fun saveTransaction(transaction: Transaction) {
        TODO("Not yet implemented")
    }

    override fun getTransactions(user: String, date: LocalDate): List<Transaction> {
        TODO("Not yet implemented")
    }
}