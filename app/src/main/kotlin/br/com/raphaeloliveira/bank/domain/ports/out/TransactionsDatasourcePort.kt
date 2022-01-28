package br.com.raphaeloliveira.bank.domain.ports.out

import br.com.raphaeloliveira.bank.domain.models.Transaction
import java.time.LocalDate

interface TransactionsDatasourcePort {
    fun saveTransaction(transaction: Transaction)
    fun getTransactions(user: String, date: LocalDate): List<Transaction>
}