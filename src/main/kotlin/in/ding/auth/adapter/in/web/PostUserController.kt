package `in`.ding.auth.adapter.`in`.web

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import `in`.ding.auth.application.port.`in`.SignUpCommand
import `in`.ding.auth.application.port.`in`.SignUpUseCase
import java.util.*

@RestController
@Validated
class PostUserController(
    private val signUpUseCase: SignUpUseCase,
) {
    @PostMapping("api/v1/auth/users")
    fun signUp(@RequestBody req_body:PostUserRequest):Boolean{
        val command = SignUpCommand(mobilePhoneNumber=req_body.mobilePhoneNumber, name = req_body.name, nickName= req_body.nickName, password=req_body.password)
        return signUpUseCase.signUp(command=command)
    }
}
