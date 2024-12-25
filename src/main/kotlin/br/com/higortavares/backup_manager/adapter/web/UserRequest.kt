package br.com.higortavares.backup_manager.adapter.web

import br.com.higortavares.backup_manager.domain.model.User
import jakarta.validation.constraints.NotBlank


data class UserRequest(
    @field:NotBlank(message = "Username must not be blank")
    val username: String,
    val password: String
) {
    fun toDomain(): User = User(username = this.username, password = this.password)
}