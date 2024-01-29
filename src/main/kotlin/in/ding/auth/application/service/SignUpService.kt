package `in`.ding.auth.application.service

import UserRepository
import `in`.ding.auth.adapter.out.persistence.UserJPAEntity
import `in`.ding.auth.application.port.`in`.SignUpCommand
import `in`.ding.auth.application.port.`in`.SignUpUseCase
import `in`.ding.auth.domain.User
import org.springframework.beans.factory.annotation.Autowired

class SignUpService @Autowired constructor(
    private val userRepository: UserRepository
) : SignUpUseCase {
    override fun signUp(command: SignUpCommand) {
        val user = User.register(
            mobilePhoneNumber = command.mobilePhoneNumber,
            name = command.name, nickName = command.nickName, password = command.password
        )

        val userJPAEntity: UserJPAEntity = UserJPAEntity.convertDomainEntityToJPAEntity(domainEntity = user)
        userRepository.save(userJPAEntity)
    }

}