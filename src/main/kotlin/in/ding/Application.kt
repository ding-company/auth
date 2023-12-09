package `in`.ding

import `in`.ding.auth.application.port.`in`.SignUpUseCase
import `in`.ding.auth.application.service.SignUpService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application{
    @Bean
    fun signUpUseCase(): SignUpUseCase {
        return SignUpService()
    }
}

fun main(args: Array<String>) {
    println("HelloWord")
    runApplication<Application>(*args)
    println("HelloWord")
}