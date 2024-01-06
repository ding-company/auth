package `in`.ding.auth.`in`.web

import `in`.ding.auth.domain.User
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.*

class TestUser {
    @Test
    fun testRegister() {
        // Given
        mockkStatic(UUID::class)
        mockkStatic(LocalDateTime::class)
        val mockedUUID = UUID.randomUUID()
        val dateNow = LocalDateTime.now()
        every { UUID.randomUUID() } returns mockedUUID
        every { LocalDateTime.now() } returns dateNow

        var testMobilePhoneNumber = "testMpn"
        var testName = "testName"
        var testPassword = "testPassword"

        // When
        val user = User.register(
            mobilePhoneNumber = testMobilePhoneNumber, name = testName, password = testPassword
        )

        // Then
        verify { UUID.randomUUID() }
        verify { LocalDateTime.now() }
        assertEquals(testName, user.name)
        assertEquals(testMobilePhoneNumber, user.mobilePhoneNumber)
        assertEquals(testPassword, user.password)
        assertEquals(mockedUUID, user.id)
        assertEquals(dateNow, user.createdAt)
        assertEquals(dateNow, user.updatedAt)
        assertEquals(dateNow, user.registeredAt)
    }
}
