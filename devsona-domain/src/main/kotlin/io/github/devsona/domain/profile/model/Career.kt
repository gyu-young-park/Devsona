package io.github.devsona.domain.profile.model

import java.time.LocalDateTime

class Career(
    val id: Long,
    val profileId: Long,
    var name: String,
    var position: String,
    var company: String,
    var skils: List<String>? = null,
    var startAt: LocalDateTime,
    var endAt: LocalDateTime? = null,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
}