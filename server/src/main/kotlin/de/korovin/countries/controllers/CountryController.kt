package de.korovin.countries.controllers

import de.korovin.countries.models.Country
import de.korovin.countries.services.CSVService
import de.korovin.countries.services.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*



/**
 * Created by aw3s0 on 10/11/2017.
 * Main controller for countries
 */
@RestController
@CrossOrigin(origins = arrayOf("http://localhost:4200"))
@RequestMapping("/country")
class CountryController(
        private @Autowired var service: CountryService,
        private @Autowired var csvService: CSVService) {
    /**
     * Fetch all countries as list
     */
    @RequestMapping("/",
            method = arrayOf(RequestMethod.GET))
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): List<Country> {
        return service.getAll()
    }

    @RequestMapping("/csv",
            method = arrayOf(RequestMethod.GET))
    @ResponseStatus(HttpStatus.OK)
    fun findAllCSV(): ResponseEntity<String> {
        val res = service.getAll()
        val csv = csvService.convertList(res.toMutableList())

        val headers = HttpHeaders()
        headers.contentType = MediaType("text", "csv")
        return ResponseEntity(csv, headers, HttpStatus.OK)
    }
}
