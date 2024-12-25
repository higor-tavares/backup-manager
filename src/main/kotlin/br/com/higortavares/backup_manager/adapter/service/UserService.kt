package br.com.higortavares.backup_manager.adapter.service

import br.com.higortavares.backup_manager.adapter.persistence.UserEntity
import br.com.higortavares.backup_manager.adapter.persistence.UserRepository
import br.com.higortavares.backup_manager.domain.model.User
import br.com.higortavares.backup_manager.domain.usecase.UsersUseCase
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository):UsersUseCase {

    override fun save(user: User): User {
        val entity = userRepository.save(UserEntity.from(user))
        return UserEntity.toDomain(entity)
    }

    override fun findAll(): List<User> = userRepository.findAll().map { UserEntity.toDomain(it) }
        .toList()
}