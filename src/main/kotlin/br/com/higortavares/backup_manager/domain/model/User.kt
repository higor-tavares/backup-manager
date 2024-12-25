package br.com.higortavares.backup_manager.domain.model

import java.util.UUID

data class User(
    val userId: UUID? = null,
    val username: String,
    val password: String
)