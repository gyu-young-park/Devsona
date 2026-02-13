package io.github.devsona.infra.persistence.member.repository

import io.github.devsona.infra.persistence.member.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

interface MemberEntityRepository: JpaRepository<MemberEntity, Long> {
    fun findByEmail(email: String): MemberEntity?
}