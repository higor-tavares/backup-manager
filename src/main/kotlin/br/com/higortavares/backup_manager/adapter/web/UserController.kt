package br.com.higortavares.backup_manager.adapter.web

import br.com.higortavares.backup_manager.domain.usecase.UsersUseCase
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val usersUseCase: UsersUseCase) {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun save(
        @RequestBody
        @Valid
        user: UserRequest
    ) = usersUseCase.save(user.toDomain())
        .let { ResponseEntity.ok(it) }

    @GetMapping
    fun findAll() = usersUseCase.findAll().let { ResponseEntity.ok(it) }
}