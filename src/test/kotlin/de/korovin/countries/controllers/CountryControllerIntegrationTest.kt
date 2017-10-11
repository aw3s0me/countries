package de.korovin.countries.controllers

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

/**
 * Created by aw3s0 on 10/11/2017.
 */
@RunWith(SpringRunner::class)
@SpringBootTest
class CountryControllerIntegrationTest {
    @Autowired
    lateinit var controller: CountryController

    @Test
    fun `should fetch all countries from controller when initializing from bootstrapper`() {
        val countries = controller.findAll()
        assertThat(countries).hasSize(252)
        assertThat(countries).extracting("name")
                .contains("Russian Federation", "Germany")
        assertThat(countries).extracting("shortName")
                .contains("RU", "DE")
    }
}
