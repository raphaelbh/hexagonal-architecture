package br.com.raphaeloliveira.bank.adapters.`in`.http.controllers

import br.com.raphaeloliveira.bank.adapters.`in`.http.models.TransactionRequest
import br.com.raphaeloliveira.bank.adapters.`in`.http.models.TransactionResponse
import br.com.raphaeloliveira.bank.domain.ports.`in`.GetTransactionsServicePort
import br.com.raphaeloliveira.bank.domain.ports.`in`.SaveTransactionServicePort
import br.com.raphaeloliveira.bank.domain.services.commands.GetTransactionsCommand
import br.com.raphaeloliveira.bank.domain.services.commands.SaveTransactionCommand
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/transactions")
class TransactionsController(
    private val saveTransactionServicePort: SaveTransactionServicePort,
    private val getTransactionsServicePort: GetTransactionsServicePort) {

    @PostMapping
    fun saveTransaction(@RequestBody request: TransactionRequest) {
        val command = SaveTransactionCommand(request.user, request.amount, request.description)
        saveTransactionServicePort.execute(command)
    }

    @GetMapping
    fun getTransactions(@RequestParam(required = true) user: String,
                        @RequestParam date: LocalDate?): List<TransactionResponse> {
        val command = GetTransactionsCommand(user, date)
        val transactions = getTransactionsServicePort.execute(command)
        return transactions.map { TransactionResponse.build(it) }
    }
}