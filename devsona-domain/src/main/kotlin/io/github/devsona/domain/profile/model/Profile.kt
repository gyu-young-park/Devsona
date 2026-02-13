package io.github.devsona.domain.profile.model

import java.time.LocalDateTime

class Profile(
    val name: String,
    val memberId: Long,
    var email: String,
    var profileAvatarUrl: String? = null,
    var description: String,
    var skils: List<String>? = null,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {

}