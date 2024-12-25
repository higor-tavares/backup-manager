package br.com.higortavares.backup_manager.adapter.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID;

@Repository
interface  UserRepository: JpaRepository<br.com.higortavares.backup_manager.adapter.persistence.UserEntity, UUID>{
}