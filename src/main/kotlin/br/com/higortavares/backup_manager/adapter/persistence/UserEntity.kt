package br.com.higortavares.backup_manager.adapter.persistence

import br.com.higortavares.backup_manager.adapter.security.SecurityHelper
import br.com.higortavares.backup_manager.domain.model.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Base64
import java.util.UUID

@Entity
@Table(name="users")
data class UserEntity(
    @Id
    @Column(name="user_id")
    val userId: UUID = UUID.randomUUID(),
    @Column(unique = true)
    val username: String,
    val password: String,
    val passwordSalt: String
) {
    companion object {

        fun from(user: User) : UserEntity {
            val salt = SecurityHelper.generateSalt()
            return UserEntity(
                username = user.username,
                password = SecurityHelper.hashPassword(user.password, salt),
                passwordSalt = Base64.getEncoder().encodeToString(salt)
            )
        }

        fun toDomain(entity: UserEntity) = User(
            userId = entity.userId,
            username = entity.username,
            password = entity.password
        )
    }
}