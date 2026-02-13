package io.github.devsona.domain.profile.model

import java.time.LocalDateTime

class Certificate(
    val id: Long,
    val profileId: Long,
    var name: String,
    var institution: String,
    var achiveDate: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
}