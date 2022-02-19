package br.com.raphaeloliveira.bank.domain.services.commands

import java.time.LocalDate

data class GetTransactionsCommand(val user: String, val date: LocalDate?) {
    fun valid(): Boolean = user.isNotBlank()
}