package br.com.raphaeloliveira.bank.adapters.out.datasource

import br.com.raphaeloliveira.bank.domain.models.Transaction
import br.com.raphaeloliveira.bank.domain.ports.out.TransactionsDatasourcePort
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class TransactionsDatasource: TransactionsDatasourcePort {

    override fun saveTransaction(transaction: Transaction) =
        TransactionsTable.insert(TransactionRow.build(transaction))

    override fun getTransactions(user: String, date: LocalDate) =
        TransactionsTable.query(user, date).map { it ->  it.toTransactionDomain()}
}