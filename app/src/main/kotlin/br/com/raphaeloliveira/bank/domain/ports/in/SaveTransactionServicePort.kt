package br.com.raphaeloliveira.bank.domain.ports.`in`

import br.com.raphaeloliveira.bank.domain.services.commands.SaveTransactionCommand

interface SaveTransactionServicePort {
    fun execute(command: SaveTransactionCommand)
}