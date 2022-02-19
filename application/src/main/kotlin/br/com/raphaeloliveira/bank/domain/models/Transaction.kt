package br.com.raphaeloliveira.bank.domain.models

import br.com.raphaeloliveira.bank.domain.services.commands.SaveTransactionCommand
import java.time.LocalDate
import java.util.UUID

data class Transaction(
    var id: String,
    var user: String,
    var date: LocalDate,
    var amount: Double,
    var description: String) {

    companion object {
        fun build(command: SaveTransactionCommand) =
            Transaction(UUID.randomUUID().toString(), command.user, LocalDate.now(), command.amount, command.description)
        fun build(map: Map<String, Any>) =
            Transaction(map["id"] as String, map["user"] as String, map["date"] as LocalDate,
                map["amount"] as Double, map["description"] as String)
    }

    fun toMap(): Map<String, Any> =
        mapOf("id" to id, "user" to user, "date" to date, "amount" to amount, "description" to description)
}