package io.github.devsona.domain.member.repository

import io.github.devsona.domain.member.model.Member

interface MemberRepository {
    fun save(member: Member)
    fun findByEmail(email: String): Member?
    fun findById(id: Long): Member?
    fun isExistsByEmail(email: String): Boolean
}