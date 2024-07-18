package `in`.ding.auth.domain

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.UUID

class TestUser {
    @Test
    fun testRegister() {
        mockkStatic(UUID::class)
        mockkStatic(LocalDateTime::class)
        val mockedUUID = UUID.randomUUID()
        val dateNow = LocalDateTime.now()
        val testMobilePhoneNumber = "testMpn"
        val testName = "testName"
        val testPassword = "testPassword"
        every { UUID.randomUUID() } returns mockedUUID
        every { LocalDateTime.now() } returns dateNow

        // When
        val user = User.register(
            mobilePhoneNumber = testMobilePhoneNumber,
            name = testName,
            password = testPassword
        )

        // Then
        verify { UUID.randomUUID() }
        verify { LocalDateTime.now() }
        assertEquals(testName, user.name)
        assertEquals(testMobilePhoneNumber, user.mobilePhoneNumber)
        assertEquals(testPassword, user.password)
        assertEquals(dateNow, user.createdAt)
        assertEquals(dateNow, user.updatedAt)
        assertEquals(dateNow, user.registeredAt)
    }
}
