package br.com.higortavares.backup_manager.adapter.service

import br.com.higortavares.backup_manager.adapter.persistence.UserEntity
import br.com.higortavares.backup_manager.adapter.persistence.UserRepository
import br.com.higortavares.backup_manager.domain.error.UserAlreadyExistsException
import br.com.higortavares.backup_manager.domain.model.User
import br.com.higortavares.backup_manager.domain.usecase.UsersUseCase
import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository):UsersUseCase {

    private val logger = LoggerFactory.getLogger(UserService::class.java)

    override fun save(user: User): User {
        try {
            val entity = userRepository.save(UserEntity.from(user))
            return UserEntity.toDomain(entity).also { logger.info("User [${user.username}] successfully saved!") }
        } catch (ex: DataIntegrityViolationException) {
           throw ex.message.also{
               logger.error("Cannot save user [${user.username}] Error: [${ex.message}]")
           }?.takeIf {
               it.contains("ERROR: duplicate key value violates unique constraint")
           }?.let { UserAlreadyExistsException() } ?: ex
        }
    }

    override fun findAll(): List<User> = userRepository.findAll().map { UserEntity.toDomain(it) }
        .toList()
}