package `in`.ding.auth.adapter.`in`.web

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class PostUserRequest(
    val mobilePhoneNumber: String,
    val name: String,
    val nickName: String?,
    val password: String,
)
