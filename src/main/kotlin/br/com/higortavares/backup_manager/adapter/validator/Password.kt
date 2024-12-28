package br.com.higortavares.backup_manager.adapter.validator

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PasswordValidator::class])
@MustBeDocumented
annotation class Password (
    val message: String = "Weak password! Your password must have 8 or more characters and have lowercase and uppercase, numbers and especial characters",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []
)