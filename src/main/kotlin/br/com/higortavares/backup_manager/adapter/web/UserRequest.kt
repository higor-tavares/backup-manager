package br.com.higortavares.backup_manager.adapter.web

import br.com.higortavares.backup_manager.domain.model.User

data class UserRequest(
    val username: String,
    val password: String
) {
    fun toDomain(): User = User(username = this.username, password = this.password)
}