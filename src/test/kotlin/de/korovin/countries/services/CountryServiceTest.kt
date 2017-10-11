package de.korovin.countries.services

import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.whenever
import de.korovin.countries.models.Country
import de.korovin.countries.persistence.CountryRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by aw3s0 on 10/10/2017.
 */
@RunWith(MockitoJUnitRunner::class)
class CountryServiceTest {
    @Mock
    lateinit var repository: CountryRepository

    lateinit var service: CountryService
    val many: MutableList<Country> = mutableListOf()

    @Before
    fun setUp() {
        many.add(Country("Country1", "CT1"))
        many.add(Country("Country2", "CT2"))

        service = CountryService(repository)
    }

    @Test
    fun `should find all countries`() {
        whenever(repository.findAll()).thenReturn(many)
        val res = service.getAll()

        assertThat(res).hasSize(2).contains(many[0], many[1])
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