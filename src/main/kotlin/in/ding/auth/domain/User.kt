package `in`.ding.auth.domain

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.time.LocalDateTime
import java.util.UUID

data class User private constructor(
    var id: UUID,
    val mobilePhoneNumber: String,
    val name: String,
    val nickName: String?,
    val password: String,
    val registeredAt: LocalDateTime,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun register(mobilePhoneNumber: String, name: String, nickName: String? = null, password: String): User {
            val datetimeNow = LocalDateTime.now()
            val hashedPassword = BCryptPasswordEncoder().encode(password)
            return User(
                id = UUID.randomUUID(),
                mobilePhoneNumber = mobilePhoneNumber,
                name = name,
                nickName = nickName,
                password = hashedPassword,
                registeredAt = datetimeNow,
                createdAt = datetimeNow,
                updatedAt = datetimeNow
            )
        }
    }
}