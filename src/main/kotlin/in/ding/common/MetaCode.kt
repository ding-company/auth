package `in`.ding.common.model

import com.fasterxml.jackson.annotation.JsonValue
import org.springframework.http.HttpStatus

enum class MetaCode(private var code: String) {
    SUCCESS("20000000"),
    CREATED("20100000"),
    ACCEPTED("20200000"),
    NO_CONTENT("20400000"),
    BAD_REQUEST("40000000"),
    AUTHENTICATION_FAILED("40100000"),
    FORBIDDEN("40300000"),
    NOT_FOUND("40400000"),
    METHOD_NOW_ALLOWED("40500000"),
    INTERNAL_SERVER_ERROR("50000000");

    @JsonValue
    override fun toString(): String {
        return this.code
    }
    companion object {
        @Suppress("CyclomaticComplexMethod")
        fun valueFrom(status: HttpStatus) = when (status) {
            HttpStatus.OK -> SUCCESS
            HttpStatus.CREATED -> CREATED
            HttpStatus.ACCEPTED -> ACCEPTED
            HttpStatus.NO_CONTENT -> NO_CONTENT
            HttpStatus.BAD_REQUEST -> BAD_REQUEST
            HttpStatus.UNAUTHORIZED -> AUTHENTICATION_FAILED
            HttpStatus.FORBIDDEN -> FORBIDDEN
            HttpStatus.NOT_FOUND -> NOT_FOUND
            HttpStatus.METHOD_NOT_ALLOWED -> METHOD_NOW_ALLOWED
            HttpStatus.INTERNAL_SERVER_ERROR -> INTERNAL_SERVER_ERROR
            else -> throw IllegalArgumentException("Please provide correct status.")
        }
    }
}
