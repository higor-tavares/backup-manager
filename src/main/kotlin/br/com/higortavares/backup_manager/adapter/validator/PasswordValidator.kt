package br.com.higortavares.backup_manager.adapter.validator

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class PasswordValidator:ConstraintValidator<Password, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return value?.let {
            it.length > 8
            && it.trim().isNotEmpty()
            && it.contains(Regex("[A-Z]"))
            && it.contains(Regex("[a-z]"))
            && it.contains(Regex("[#^.$*@&(){}!]"))
            && it.contains(Regex("\\d"))
        } ?: false
    }
}