package de.korovin.countries.controllers

import de.korovin.countries.models.Country
import de.korovin.countries.services.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/**
 * Created by aw3s0 on 10/11/2017.
 * Main controller for countries
 */
@RestController
@CrossOrigin(origins = arrayOf("http://localhost:4200"))
@RequestMapping("/country")
class CountryController(private @Autowired var service: CountryService) {
    /**
     * Fetch all countries as list
     */
    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): List<Country> {
        return service.getAll()
    }
}
