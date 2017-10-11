package de.korovin.countries.controllers

import com.jayway.jsonassert.impl.matcher.IsCollectionWithSize.hasSize
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.whenever
import de.korovin.countries.models.Country
import de.korovin.countries.services.CountryService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders

/**
 * Created by aw3s0 on 10/11/2017.
 */
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
class CountryControllerTest {
    val API: String = "/country/"

    lateinit var mockMvc: MockMvc

    @Mock
    lateinit var service: CountryService

    @InjectMocks
    lateinit var controller: CountryController

    val many: List<Country> = listOf(
            Country("Country1", "CT1"),
            Country("Country2", "CT2")
    )

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setMessageConverters(MappingJackson2HttpMessageConverter())
                .build()
    }

    @Test
    fun `should return ok json array when service returns not empty list`() {
        whenever(service.getAll()).thenReturn(many)

        mockMvc.perform(get(API))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].name").value(many[0].name))
                .andExpect(jsonPath("$[1].name").value(many[1].name))
                .andExpect(jsonPath("$[0].shortName").value(many[0].shortName))
                .andExpect(jsonPath("$[1].shortName").value(many[1].shortName))
        verify(service, times(1)).getAll()
        verifyNoMoreInteractions(service)
    }

    @Test
    fun `should return ok empty json array when service returns empty list`() {
        whenever(service.getAll()).thenReturn(emptyList())

        mockMvc.perform(get(API))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(0)))
        verify(service, times(1)).getAll()
        verifyNoMoreInteractions(service)
    }
}
