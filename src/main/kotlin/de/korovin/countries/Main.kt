package de.korovin.countries

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Configuration

@EnableAutoConfiguration
@Configuration
class Application

/**
 * Created by aw3s0 on 10/10/2017.
 */
fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}