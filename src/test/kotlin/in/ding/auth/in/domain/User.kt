package `in`.ding.auth.`in`.web

import `in`.ding.auth.domain.User
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class TestUser {
    @Test
    fun testRegister() {
        // Given
        mockkStatic(UUID::class)
        val mockedUUID = UUID.randomUUID()
        every { UUID.randomUUID() } returns mockedUUID

        var testMobilePhoneNumber = "testMpn"
        var testName = "testName"
        var testPassword = "testPassword"

        // When
        val user = User.register(
            mobilePhoneNumber = testMobilePhoneNumber, name = testName, password = testPassword
        )

        // Then
        verify { UUID.randomUUID() }
        assertEquals(testName, user.name)
        assertEquals(testMobilePhoneNumber, user.mobilePhoneNumber)
        assertEquals(testPassword, user.password)
        assertEquals(mockedUUID, user.id)
    }
}