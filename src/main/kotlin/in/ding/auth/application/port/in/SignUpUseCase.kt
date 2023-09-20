package `in`.ding.auth.application.port.`in`

import  org.springframework.stereotype.Service

@Service
interface SignUpUseCase {
    fun signUp(command:SignUpCommand): Boolean
}