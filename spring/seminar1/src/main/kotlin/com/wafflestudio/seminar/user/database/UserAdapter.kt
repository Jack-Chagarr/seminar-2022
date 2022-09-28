package com.wafflestudio.seminar.user.database

import com.wafflestudio.seminar.user.domain.User
import com.wafflestudio.seminar.user.domain.UserPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class UserAdapter(
    private val userRepository: UserRepository,
) : UserPort {
    override fun getUser(id: Int): User {
        val entity = userRepository.findByIdOrNull(id.toLong()) ?: throw IllegalArgumentException("USER#$id NOT FOUND!")
        return entity.toUser()
    }
    
    fun createUser(name: String){
        val newUser = UserEntity()
        userRepository.save(newUser)
    }
    @Transactional
    fun updateUser(name: String, age : Int){
        var newUser = userRepository.findByName(name)
        newUser.age = 12
    }
}