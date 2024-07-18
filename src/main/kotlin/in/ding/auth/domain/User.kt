package `in`.ding.auth.domain

import java.time.LocalDateTime
import java.util.UUID

class User(
    val uid: String,
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
            return User(
                uid = UUID.randomUUID().toString(),
                mobilePhoneNumber = mobilePhoneNumber,
                name = name,
                nickName = nickName,
                password = password,
                registeredAt = datetimeNow,
                createdAt = datetimeNow,
                updatedAt = datetimeNow
            )
        }
    }
}
