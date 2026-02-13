package io.github.devsona.domain.member.model

import java.time.LocalDateTime

class Member(
    val id: Long? = null,
    val username: String,
    val alias: String? = null,
    var email: String,
    var age: Int,
    ) {
}