package br.com.raphaeloliveira.bank.domain.services

import br.com.raphaeloliveira.bank.domain.models.Transaction
import br.com.raphaeloliveira.bank.domain.ports.`in`.SaveTransactionServicePort
import br.com.raphaeloliveira.bank.domain.ports.out.EmailServicePort
import br.com.raphaeloliveira.bank.domain.ports.out.TransactionsDatasourcePort
import br.com.raphaeloliveira.bank.domain.services.commands.SaveTransactionCommand
import br.com.raphaeloliveira.bank.domain.services.exceptions.InvalidCommand
import org.springframework.stereotype.Service

@Service
class SaveTransactionService(
    private val transactionsDatasourcePort: TransactionsDatasourcePort,
    private val emailServicePort: EmailServicePort) : SaveTransactionServicePort {

    override fun execute(command: SaveTransactionCommand) {

        if (!command.valid()) throw InvalidCommand()

        val transaction = Transaction.build(command)
        transactionsDatasourcePort.saveTransaction(transaction)
        emailServicePort.send(transaction.user, "Transaction ${transaction.id} has been committed.")
    }
}