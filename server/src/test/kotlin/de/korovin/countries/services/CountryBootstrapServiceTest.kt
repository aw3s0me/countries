package de.korovin.countries.services

import com.nhaarman.mockito_kotlin.whenever
import de.korovin.countries.helpers.UrlOpener
import de.korovin.countries.models.Country
import de.korovin.countries.persistence.CountryRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Spy
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import java.io.BufferedReader
import java.io.StringReader


/**
 * Created by aw3s0 on 10/11/2017.
 */
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
class CountryBootstrapServiceTest {
    @Spy
    private lateinit var repository: FakeRepository

    @Mock
    lateinit var opener: UrlOpener

    lateinit var service: CountryBootstrapService

    val URI: String = "http://test.com"

    @Before
    fun setUp() {
        service = CountryBootstrapService(repository, opener, URI)
    }

    @Test
    fun `should read and persist all correct lines`() {
        val reader = StringReader("This list obtained from\n" +
                "http://link.com / http://link2.com\n" +
                "AD   Andorra\n" +
                "AE   United Arab Emirates")

        whenever(opener.fetchStreamFromUrl(URI))
                .thenReturn(BufferedReader(reader))

        service.bootstrap()
        assertThat(repository.list).hasSize(2)
        val names = repository.list.map { it.name }
        assertThat(names).hasSize(2).contains("Andorra", "United Arab Emirates")
        val shortNames = repository.list.map { it.shortName }
        assertThat(shortNames).hasSize(2).contains("AD", "AE")
    }

    @Test
    fun `should read and persist only one correct line`() {
        val reader = StringReader("This list obtained from\n" +
                "http://link.com / http://link2.com\n" +
                "AD  \n" +
                "AE   United Arab Emirates")

        whenever(opener.fetchStreamFromUrl(URI))
                .thenReturn(BufferedReader(reader))

        service.bootstrap()
        assertThat(repository.list).hasSize(1)
        val names = repository.list.map { it.name }
        assertThat(names).hasSize(1).contains("United Arab Emirates")
        val shortNames = repository.list.map { it.shortName }
        assertThat(shortNames).hasSize(1).contains("AE")
    }

    abstract class FakeRepository: CountryRepository {
        val list: MutableList<Country> = mutableListOf()
        override fun <S : Country?> save(entity: S): S {
            list.add(entity as Country)
            return entity
        }
    }
}
