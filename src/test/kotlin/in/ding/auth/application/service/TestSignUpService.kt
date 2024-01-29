package `in`.ding.auth.application.service

import UserRepository
import `in`.ding.auth.adapter.out.persistence.UserJPAEntity
import `in`.ding.auth.application.port.`in`.SignUpCommand
import `in`.ding.auth.domain.User
import io.mockk.*
import org.junit.jupiter.api.Test

class TestSignUpService {
    @Test
    fun testSignUp(){
        // Given
        val userRepository = mockk<UserRepository>()
        val expectedUserJPAEntity = mockk<UserJPAEntity>()
        val userEntity = mockk<User>()
        mockkObject(User.Companion)
        mockkObject(UserJPAEntity.Companion)

        every { userRepository.save(any()) } returns expectedUserJPAEntity
        every { User.Companion.register(any(), any(), any(), any()) } returns userEntity
        every { UserJPAEntity.Companion.convertDomainEntityToJPAEntity(any()) } returns expectedUserJPAEntity

        val signUpService = SignUpService(userRepository)
        val signUpCommand = SignUpCommand(
            mobilePhoneNumber = "1234567890",
            name = "John Doe",
            nickName = "johndoe",
            password = "password123"
        )

        // When
        signUpService.signUp(signUpCommand)

        // Then
        verify(exactly = 1) { userRepository.save(expectedUserJPAEntity) }
        verify(exactly = 1) { User.register(signUpCommand.mobilePhoneNumber,signUpCommand.name,signUpCommand.nickName,signUpCommand.password) }
        verify(exactly = 1) { UserJPAEntity.convertDomainEntityToJPAEntity(userEntity) }
        unmockkObject(User.Companion)
        unmockkObject(UserJPAEntity.Companion)
    }
}
