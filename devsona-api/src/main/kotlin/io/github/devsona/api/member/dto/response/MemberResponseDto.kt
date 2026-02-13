package io.github.devsona.api.member.dto.response

data class MemberResponseDto(
    val username: String,
    val alias: String,
    val email: String,
    val age: Int,
)