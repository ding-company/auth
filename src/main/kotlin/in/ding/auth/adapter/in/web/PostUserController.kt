package `in`.ding.auth.adapter.`in`.web

import `in`.ding.auth.application.port.`in`.SignUpCommand
import `in`.ding.auth.application.port.`in`.SignUpUseCase
import `in`.payhere.common.dto.response.ResponseDTO
import `in`.payhere.common.model.MetaCode
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@Validated
@ResponseStatus(HttpStatus.CREATED)
class PostUserController(
    private val signUpUseCase: SignUpUseCase,
) {
    @PostMapping("/api/v1/auth/users")
    fun signUp(@RequestBody req_body:PostUserRequest):ResponseDTO<String>{
        val command = SignUpCommand(mobilePhoneNumber=req_body.mobilePhoneNumber, name = req_body.name, nickName= req_body.nickName, password=req_body.password)

        signUpUseCase.signUp(command=command)
        return ResponseDTO(meta = ResponseDTO.Meta(code = MetaCode.CREATED))
    }
}
