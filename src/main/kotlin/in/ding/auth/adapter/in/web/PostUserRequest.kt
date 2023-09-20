package `in`.ding.auth.adapter.`in`.web

data class PostUserRequest(
    val mobilePhoneNumber: String,
    val name: String,
    val nickName: String?,
    val password: String,
)