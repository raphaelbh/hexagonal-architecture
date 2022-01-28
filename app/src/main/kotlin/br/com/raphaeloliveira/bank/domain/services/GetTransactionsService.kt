package br.com.raphaeloliveira.bank.domain.services

import br.com.raphaeloliveira.bank.domain.models.Transaction
import br.com.raphaeloliveira.bank.domain.ports.`in`.GetTransactionsServicePort
import br.com.raphaeloliveira.bank.domain.ports.out.TransactionsDatasourcePort
import br.com.raphaeloliveira.bank.domain.services.commands.GetTransactionsCommand
import br.com.raphaeloliveira.bank.domain.services.exceptions.InvalidCommand
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class GetTransactionsService(
    private val transactionsDatasourcePort: TransactionsDatasourcePort): GetTransactionsServicePort {

    override fun execute(command: GetTransactionsCommand): List<Transaction> {

        if (!command.valid()) throw InvalidCommand()

        val searchDate = command.date ?: LocalDate.now()
        return transactionsDatasourcePort.getTransactions(command.user, searchDate)
    }
}