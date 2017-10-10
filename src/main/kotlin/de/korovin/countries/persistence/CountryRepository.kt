package de.korovin.countries.persistence

import de.korovin.countries.models.Country
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

/**
 * Created by aw3s0 on 10/10/2017.
 * CRUD repository for countries
 * which accesses them by their short name
 */
@Repository
@Transactional
interface CountryRepository : CrudRepository<Country, Long>
