package io.github.devsona.api.member.controller

import io.github.devsona.api.member.dto.request.CreateMemberRequestDto
import io.github.devsona.api.member.dto.response.MemberResponseDto
import io.github.devsona.api.member.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/member")
open class MemberController(
    private val memberService: MemberService
) {
    @PostMapping("/register")
    open fun createMember(
        @RequestBody dto: CreateMemberRequestDto
    ): ResponseEntity<MemberResponseDto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.createMember(dto))
    }

    @GetMapping("/{email}")
    open fun getMemberByEmail(
        @PathVariable email: String
    ): ResponseEntity<MemberResponseDto> {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findMemberByEmail(email))
    }
}