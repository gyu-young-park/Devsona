package io.github.devsona.api.member.service

import io.github.devsona.api.member.dto.request.CreateMemberRequestDto
import io.github.devsona.api.member.dto.response.MemberResponseDto
import io.github.devsona.domain.member.model.Member
import io.github.devsona.domain.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
open class MemberService(
    private val memberRepository: MemberRepository
) {
    open fun createMember(dto: CreateMemberRequestDto): MemberResponseDto {
        if (memberRepository.isExistsByEmail(dto.email)) {
            throw IllegalArgumentException("Email already exists")
        }
        val member = Member(null, dto.username, dto.alias, dto.email, dto.age)
        memberRepository.save(member)
        return MemberResponseDto(member.username, member.alias ?: member.username, member.email, member.age)
    }

    open fun findMemberByEmail(email: String): MemberResponseDto {
        val member = memberRepository.findByEmail(email) ?: throw IllegalArgumentException("Email does not exist")
        return MemberResponseDto(member.username, member.alias ?: member.username, member.email, member.age)
    }
}