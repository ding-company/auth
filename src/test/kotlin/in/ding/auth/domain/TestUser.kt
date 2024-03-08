package `in`.ding.auth.`in`.web

import `in`.ding.auth.domain.User
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.time.LocalDateTime
import java.util.*

class TestUser {
    @Test
    fun testRegister() {
        mockkStatic(UUID::class)
        mockkStatic(LocalDateTime::class)
        val passwordEncoderMock = mockk<BCryptPasswordEncoder>()
        val mockedUUID = UUID.randomUUID()
        val dateNow = LocalDateTime.now()
        val testMobilePhoneNumber = "testMpn"
        val testName = "testName"
        val testPassword = "testPassword"
        val testHashedPw = "testPw"
        every { UUID.randomUUID() } returns mockedUUID
        every { LocalDateTime.now() } returns dateNow
        every { passwordEncoderMock.encode(testPassword) } returns testHashedPw

        // When
        val user = User.register(
            mobilePhoneNumber = testMobilePhoneNumber, name = testName, password = testPassword
        )

        // Then
        verify { UUID.randomUUID() }
        verify { LocalDateTime.now() }
        assertEquals(testName, user.name)
        assertEquals(testMobilePhoneNumber, user.mobilePhoneNumber)
        assertEquals(testHashedPw, user.password)
        assertEquals(mockedUUID, user.id)
        assertEquals(dateNow, user.createdAt)
        assertEquals(dateNow, user.updatedAt)
        assertEquals(dateNow, user.registeredAt)
    }
}
