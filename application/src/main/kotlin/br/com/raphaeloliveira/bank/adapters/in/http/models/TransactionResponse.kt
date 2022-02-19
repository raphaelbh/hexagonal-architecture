package br.com.raphaeloliveira.bank.adapters.`in`.http.models

import br.com.raphaeloliveira.bank.domain.models.Transaction
import java.time.LocalDate

data class TransactionResponse(val user: String, val date: LocalDate, val amount: Double, val description: String) {
    companion object {
        fun build(transaction: Transaction) =
            TransactionResponse(transaction.user, transaction.date, transaction.amount, transaction.description)
    }
}