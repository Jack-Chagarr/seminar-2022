package com.wafflestudio.seminar.user.database

import com.wafflestudio.seminar.common.BaseTimeEntity
import com.wafflestudio.seminar.lecture.database.LectureEntity
import com.wafflestudio.seminar.user.domain.User
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "users")
class UserEntity(
    val name: String,
    var age: Int,
    @Enumerated(EnumType.STRING)
    val gender: User.Gender,
    @OneToMany(mappedBy = "instructor")
    val lectures: List<LectureEntity>,
) : BaseTimeEntity() {

    fun toUser(): User {
        return User(
            name = name,
            age = age,
            gender = gender,
        )
    }
}