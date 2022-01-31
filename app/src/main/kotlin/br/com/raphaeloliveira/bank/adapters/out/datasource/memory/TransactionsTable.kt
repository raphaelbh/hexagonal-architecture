package br.com.raphaeloliveira.bank.adapters.out.datasource.memory

import java.time.LocalDate

class TransactionsTable {
    companion object {
        var transactions: MutableList<Map<String, Any>> = mutableListOf()

        fun insert(transaction: Map<String, Any>) { transactions.add(transaction) }

        fun query(user: String, date: LocalDate): List<Map<String, Any>> = transactions.filter {
                it -> it["user"] == user && (it["date"] as LocalDate).dayOfYear == date.dayOfYear
        }
    }
}