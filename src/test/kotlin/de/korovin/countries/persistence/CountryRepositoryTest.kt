package de.korovin.countries.persistence;

import de.korovin.countries.models.Country
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit4.SpringRunner

/**
 * Created by aw3s0 on 10/10/2017.
 */
@RunWith(SpringRunner::class)
@DataJpaTest
class CountryRepositoryTest {
    @Autowired
    lateinit var manager: TestEntityManager

    @Autowired
    lateinit var repository: CountryRepository

    @Test
    fun `should return no countries when empty`() {
        var countries = repository.findAll()
        assertThat(countries).isEmpty()
    }

    @Test
    fun `should find all countries`() {
        var country1 = Country("Country1", "CT1")
        manager.persist(country1)

        var country2 = Country("Country2", "CT2")
        manager.persist(country2)

        var country3 = Country("Country3", "CT3")
        manager.persist(country3)

        var countries = repository.findAll()
        assertThat(countries).hasSize(3).contains(country1, country2, country3)
    }

    @Test
    fun `should store a country`() {
        var country = repository.save(Country("Country", "CT"))

        assertThat(country).hasFieldOrPropertyWithValue("shortName", "CT")
        assertThat(country).hasFieldOrPropertyWithValue("name", "Country")
        assertThat(country.id).isNotNull()
        assertThat(country.id).isGreaterThan(0)

        println(country.toString())
    }
}
