package br.com.higortavares.backup_manager.domain.usecase

import br.com.higortavares.backup_manager.domain.model.User

interface UsersUseCase {
    fun save(user:User):User
    fun findAll():List<User>
}