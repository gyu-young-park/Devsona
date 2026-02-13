package io.github.devsona.domain.member.model

import java.time.LocalDateTime

class Member(
    val id: Long,
    val username: String,
    val alias: String? = null,
    var email: String,
    var age: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
    ) {
}