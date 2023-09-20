package `in`.ding.auth.application.port.`in`

data class SignUpCommand(
    val mobilePhoneNumber: String,
    val name: String,
    val nickName: String?,
    val password: String,
)