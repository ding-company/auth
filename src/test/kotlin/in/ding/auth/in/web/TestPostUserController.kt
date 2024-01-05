package `in`.ding.auth.`in`.web

import com.fasterxml.jackson.databind.ObjectMapper
import `in`.ding.auth.adapter.`in`.web.PostUserRequest
import `in`.ding.auth.application.port.`in`.SignUpUseCase
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
@AutoConfigureMockMvc
class TestPostUserController {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper
    @MockBean private lateinit var signUserCase: SignUpUseCase

    @Test
    fun testSignIn() {

        val uri: String = "/api/v1/auth/users"
        val requestBody = objectMapper.writeValueAsString(
            PostUserRequest(
                mobilePhoneNumber = "01012341234",
                name = "name",
                nickName = "test",
                password = "1231"
            )
        )
        mockMvc.perform(
            MockMvcRequestBuilders
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON).content(
                    requestBody
                )
        )
            .andExpect(MockMvcResultMatchers.status().isCreated)
            .andDo(MockMvcResultHandlers.print())
    }
}