package de.korovin.countries

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan(basePackages = arrayOf("de.korovin.countries.models"))
@EnableJpaRepositories("de.korovin.countries.persistence")
@ComponentScan(basePackages = arrayOf("de.korovin.countries"))
@SpringBootApplication
class Application

/**
 * Created by aw3s0 on 10/10/2017.
 */
fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}