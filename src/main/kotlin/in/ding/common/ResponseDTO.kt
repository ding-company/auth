package `in`.payhere.common.dto.response

import `in`.payhere.common.model.MetaCode

open class ResponseDTO<T>(
    open val meta: Meta,
    open val data: T? = null,
) {
    data class Meta(
        val code: MetaCode,
        val type: String? = code.name.lowercase(),
        val message: String? = null,
    )
}