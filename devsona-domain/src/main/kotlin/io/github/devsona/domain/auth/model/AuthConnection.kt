package io.github.devsona.domain.auth.model

import java.time.LocalDateTime

class AuthConnection(
    val id: Long,
    val memberId: Long,
    val authProvider: String,
    val authMethod: String,
    val authorizedTime: LocalDateTime,
) {
}