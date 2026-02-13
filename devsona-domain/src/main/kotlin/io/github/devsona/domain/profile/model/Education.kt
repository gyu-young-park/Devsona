package io.github.devsona.domain.profile.model

import java.time.LocalDateTime

class Education(
    val id: Long,
    val profileId: Long,
    var name: String,
    var description: String,
    var institution: String,
    var degree: String,
    var startAt: LocalDateTime,
    var endAt: LocalDateTime? = null,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
}