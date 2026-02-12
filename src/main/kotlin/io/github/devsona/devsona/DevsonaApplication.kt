package io.github.devsona.devsona

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DevsonaApplication

fun main(args: Array<String>) {
    runApplication<DevsonaApplication>(*args)
}
