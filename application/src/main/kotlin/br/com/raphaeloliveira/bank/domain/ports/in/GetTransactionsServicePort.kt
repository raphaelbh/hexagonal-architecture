package br.com.raphaeloliveira.bank.domain.ports.`in`

import br.com.raphaeloliveira.bank.domain.models.Transaction
import br.com.raphaeloliveira.bank.domain.services.commands.GetTransactionsCommand

interface GetTransactionsServicePort {
    fun execute(command: GetTransactionsCommand): List<Transaction>
}