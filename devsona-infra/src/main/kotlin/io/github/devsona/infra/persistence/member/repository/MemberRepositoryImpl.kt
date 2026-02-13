package io.github.devsona.infra.persistence.member.repository

import io.github.devsona.domain.member.model.Member
import io.github.devsona.domain.member.repository.MemberRepository
import io.github.devsona.infra.persistence.member.entity.MemberEntity
import org.springframework.stereotype.Repository

@Repository
open class MemberRepositoryImpl(
    private val memberEntityRepository: MemberEntityRepository
): MemberRepository {
    override fun save(member: Member) {
        memberEntityRepository.save(MemberEntity.from(member))
    }

    override fun findByEmail(email: String): Member? {
        return memberEntityRepository.findByEmail(email)?.to()
    }

    override fun findById(id: Long): Member? {
        return memberEntityRepository.findById(id).orElse(null)?.to()
    }

    override fun isExistsByEmail(email: String): Boolean {
        return memberEntityRepository.findByEmail(email) != null
    }
}