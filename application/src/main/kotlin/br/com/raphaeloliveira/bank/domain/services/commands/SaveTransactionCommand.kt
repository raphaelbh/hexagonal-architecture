package br.com.raphaeloliveira.bank.domain.services.commands

data class SaveTransactionCommand(val user: String, val amount: Double, val description: String) {
    fun valid(): Boolean = user.isNotBlank()
}