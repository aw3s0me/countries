package de.korovin.countries.services;

import de.korovin.countries.models.Country
import de.korovin.countries.persistence.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by aw3s0 on 10/10/2017.
 * Service for countries
 */
@Service
class CountryService(private @Autowired val repository: CountryRepository) {
    fun getAll(): List<Country> {
        return repository.findAll().toList()
    }
}
