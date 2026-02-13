package io.github.devsona.api.member.dto.request

data class CreateMemberRequestDto(
    val username: String,
    val email: String,
    val age: Int,
    val alias: String?,
)
