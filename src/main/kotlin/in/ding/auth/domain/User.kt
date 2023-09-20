package `in`.ding.auth.domain

import java.util.UUID

class User(
    id: UUID,
    mobilePhoneNumber: String,
    name: String,
    nickName: String?
)