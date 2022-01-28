package br.com.raphaeloliveira.bank.adapters.out.datasource

import br.com.raphaeloliveira.bank.domain.models.Transaction
import java.time.LocalDate

data class TransactionRow(var id: String,
                          var user: String,
                          var date: LocalDate,
                          var amount: Double,
                          var description: String) {
    companion object {
        fun build(transaction: Transaction) = TransactionRow(
                transaction.id,
                transaction.user,
                transaction.date,
                transaction.amount,
                transaction.description)
    }

    fun toTransactionDomain(): Transaction =
        Transaction(id, user, date, amount, description)
}
