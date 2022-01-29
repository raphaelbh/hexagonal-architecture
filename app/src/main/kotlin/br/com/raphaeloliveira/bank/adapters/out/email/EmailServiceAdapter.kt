package br.com.raphaeloliveira.bank.adapters.out.email

import br.com.raphaeloliveira.bank.domain.ports.out.EmailServicePort
import org.springframework.stereotype.Service

@Service
class EmailServiceAdapter: EmailServicePort {
    override fun send(user: String, message: String) {
        println("E-mail sent to $user")
    }
}