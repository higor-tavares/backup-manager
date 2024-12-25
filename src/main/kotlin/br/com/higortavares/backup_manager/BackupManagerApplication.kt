package br.com.higortavares.backup_manager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackupManagerApplication

fun main(args: Array<String>) {
	runApplication<BackupManagerApplication>(*args)
}
