package `in`.ding.auth.application.service

import `in`.ding.auth.application.port.`in`.SignUpCommand
import `in`.ding.auth.application.port.`in`.SignUpUseCase

class SignUpService:SignUpUseCase {
    override fun signUp(command: SignUpCommand): Boolean {
        TODO("Not yet implemented")
    }

}