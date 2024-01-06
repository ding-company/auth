package `in`.ding.auth.domain

import java.util.UUID

data class User private constructor(
    var id: UUID,
    val mobilePhoneNumber: String,
    val name: String,
    val nickName: String?,
    val password: String,
) {
    companion object {
        fun register(mobilePhoneNumber: String, name: String, nickName: String? = null, password: String): User {
            return User(
                id = UUID.randomUUID(),
                mobilePhoneNumber = mobilePhoneNumber,
                name = name, nickName = nickName, password = password
            )
        }
    }
}