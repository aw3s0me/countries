package de.korovin.countries.services

import de.korovin.countries.models.Country
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by aw3s0 on 10/12/2017.
 */
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
class CSVServiceTest {
    @Autowired
    lateinit var service: CSVService

    var many = mutableListOf(
            Country("Country1", "CT1"),
            Country("Country2", "CT2")
    )

    @Test
    fun convertList() {
        val res = service.convertList(many)
        assertThat(res).contains("\"id\",\"name\",\"shortName\"")
        assertThat(res).contains("\"0\",\"Country1\",\"CT1\"")
        assertThat(res).contains("\"0\",\"Country2\",\"CT2\"")
    }
}
