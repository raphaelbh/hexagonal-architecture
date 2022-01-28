package br.com.raphaeloliveira.bank.domain.ports.out

interface EmailServicePort {
    fun send(user: String, message: String)
}