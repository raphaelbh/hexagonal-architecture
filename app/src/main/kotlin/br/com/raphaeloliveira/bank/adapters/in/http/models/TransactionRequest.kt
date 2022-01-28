package br.com.raphaeloliveira.bank.adapters.`in`.http.models

data class TransactionRequest(val user: String, val amount: Double, val description: String)