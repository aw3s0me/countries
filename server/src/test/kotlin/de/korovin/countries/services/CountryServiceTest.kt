package de.korovin.countries.services

import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.whenever
import de.korovin.countries.models.Country
import de.korovin.countries.persistence.CountryRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by aw3s0 on 10/10/2017.
 */
@RunWith(MockitoJUnitRunner::class)
class CountryServiceTest {
    @Mock
    lateinit var repository: CountryRepository

    @InjectMocks
    lateinit var service: CountryService

    val many: Iterable<Country> = listOf(
            Country("Country1", "CT1"),
            Country("Country2", "CT2")
    ).asIterable()

    @Test
    fun `should find all countries`() {
        whenever(repository.findAll()).thenReturn(many)
        val res = service.getAll()

        assertThat(res).hasSize(2).contains(
                many.elementAt(0),
                many.elementAt(1))
        verify(repository, times(1)).findAll()
        verifyNoMoreInteractions(repository)
    }

    @Test
    fun `should return empty list when repository is empty`() {
        whenever(repository.findAll()).thenReturn(emptyList())
        val res = service.getAll()

        assertThat(res).isEmpty()
        verify(repository, times(1)).findAll()
        verifyNoMoreInteractions(repository)
    }
}