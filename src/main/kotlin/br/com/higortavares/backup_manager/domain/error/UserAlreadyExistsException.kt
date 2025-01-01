package br.com.higortavares.backup_manager.domain.error

data class UserAlreadyExistsException(
    override val message: String = "User already exists"
) : RuntimeException(message)