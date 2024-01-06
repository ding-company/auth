package `in`.ding.auth.application.service

import `in`.ding.auth.application.port.`in`.SignUpCommand
import `in`.ding.auth.application.port.`in`.SignUpUseCase
import `in`.ding.auth.domain.User

class SignUpService : SignUpUseCase {
    override fun signUp(command: SignUpCommand): Boolean {
        User.register(
            mobilePhoneNumber = command.mobilePhoneNumber,
            name = command.name, nickName = command.nickName, password = command.password
        )
        return true
    }

}