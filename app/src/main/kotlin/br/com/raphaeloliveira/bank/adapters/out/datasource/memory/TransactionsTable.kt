package br.com.raphaeloliveira.bank.adapters.out.datasource.memory

import java.time.LocalDate

class TransactionsTable {
    companion object {
        var transactions: MutableList<TransactionRow> = mutableListOf()

        fun insert(transactionRow: TransactionRow) { transactions.add(transactionRow) }

        fun query(user: String, date: LocalDate): List<TransactionRow> = transactions.filter {
                it -> it.user == user && it.date.dayOfYear == date.dayOfYear
        }
    }
}