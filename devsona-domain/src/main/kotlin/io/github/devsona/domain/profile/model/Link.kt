package io.github.devsona.domain.profile.model

import java.time.LocalDateTime

class Link(
    val id: Long,
    val profileId: Long,
    var url: String,
    var title: String,
    var description: String,
    var linkType: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
}