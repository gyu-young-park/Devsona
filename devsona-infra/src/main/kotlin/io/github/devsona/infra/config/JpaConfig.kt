package io.github.devsona.infra.config

import org.springframework.boot.persistence.autoconfigure.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaAuditing
@EnableJpaRepositories("io.github.devsona.infra")
@EntityScan("io.github.devsona.infra")
@Configuration
class JpaConfig {
}