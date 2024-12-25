package br.com.higortavares.backup_manager.adapter.security

import java.security.SecureRandom
import java.security.spec.KeySpec
import java.util.Base64
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec


class SecurityHelper {
    companion object {
        private const val SALT_LENGTH = 16
        private const val INTERACTIONS = 10000
        private const val KEY_LENGTH = 256
        private const val ALGORITHM = "PBKDF2WithHmacSHA256"

        fun generateSalt(): ByteArray {
            val random= SecureRandom()
            val salt = ByteArray(SALT_LENGTH)
            random.nextBytes(salt)
            return salt
        }
        fun hashPassword(password: String, salt: ByteArray): String {
            val spec: KeySpec = PBEKeySpec(password.toCharArray(), salt, INTERACTIONS, KEY_LENGTH)
            val factory = SecretKeyFactory.getInstance(ALGORITHM)
            val hash = factory.generateSecret(spec).encoded
            return Base64.getEncoder().encodeToString(hash)
        }
    }
}