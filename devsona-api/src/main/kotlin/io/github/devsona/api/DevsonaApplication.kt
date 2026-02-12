package io.github.devsona.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["io.github.devsona"])
class DevsonaApplication

fun main(args: Array<String>) {
    runApplication<DevsonaApplication>(*args)
}
