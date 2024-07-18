package `in`.ding.auth.adapter.`in`.web

import `in`.ding.auth.application.port.`in`.SignUpCommand
import `in`.ding.auth.application.port.`in`.SignUpUseCase
import `in`.ding.common.dto.response.ResponseDTO
import `in`.ding.common.model.MetaCode
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
@RequestMapping("/api/v1/users")
class UserController(
    private val signUpUseCase: SignUpUseCase,
) {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(@RequestBody reqBody: PostUserRequest): ResponseDTO<String> {
        val command = SignUpCommand(
            mobilePhoneNumber = reqBody.mobilePhoneNumber,
            name = reqBody.name,
            nickName = reqBody.nickName,
            password = reqBody.password
        )

        signUpUseCase.signUp(command = command)
        return ResponseDTO(meta = ResponseDTO.Meta(code = MetaCode.CREATED))
    }
}
