package br.com.raphaeloliveira.bank.adapters.out.datasource.memory

import br.com.raphaeloliveira.bank.domain.models.Transaction
import br.com.raphaeloliveira.bank.domain.ports.out.TransactionsDatasourcePort
import java.time.LocalDate

class TransactionsDatasourceAdapter: TransactionsDatasourcePort {

    override fun saveTransaction(transaction: Transaction) = TransactionsTable.insert(transaction.toMap())

    override fun getTransactions(user: String, date: LocalDate) =
        TransactionsTable.query(user, date).map { Transaction.build(it) }
}