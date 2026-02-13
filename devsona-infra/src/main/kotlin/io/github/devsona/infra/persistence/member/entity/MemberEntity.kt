package io.github.devsona.infra.persistence.member.entity

import io.github.devsona.domain.member.model.Member
import io.github.devsona.infra.persistence.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "member")
open class MemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var username: String,

    @Column
    var alias: String? = null,

    @Column
    var email: String,

    @Column
    var age: Int,
): BaseEntity() {
    constructor() : this(null, "", "", "", -1)

    fun to(): Member {
        return Member(
            this.id ?: throw NullPointerException("cannot convert member entity that got null id to member"),
            this.username,
            this.alias ?: this.username,
            this.email,
            this.age,
        )
    }

    companion object {
        fun from(member: Member): MemberEntity {
            return MemberEntity(
                member.id,
                member.username,
                member.alias,
                member.email,
                member.age)
        }
    }
}