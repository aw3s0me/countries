package de.korovin.countries.services

import de.korovin.countries.helpers.UrlOpener
import de.korovin.countries.models.Country
import de.korovin.countries.persistence.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

/**
 * Created by aw3s0 on 10/11/2017.
 * Service to read file of countries from url
 */
@Service
class CountryBootstrapService(
        private @Autowired val repository: CountryRepository,
        private @Autowired val opener: UrlOpener,
        @Value("\${file.uri.countries}") private val URI: String
) {
    private val DELIMITER = "   "
    private val NUM_LINE_ELEMS = 2
    private val SKIP_NUM_LINES = 1

    fun bootstrap() {
        val reader = opener.fetchStreamFromUrl(URI)
        // reads stream line by line
        // useLines automatically closes reader
        reader.useLines {
            lines -> lines.forEachIndexed { index, line ->
                // skip first two lines
                if (index > SKIP_NUM_LINES && !line.isEmpty()) {
                    parseLine(line)
                }
            }
        }
    }

    private fun parseLine(line: String) {
        // split string to short name and full name
        val lineArr = line.split(DELIMITER)
        // persist only these countries that have full info
        if (lineArr.size == NUM_LINE_ELEMS) {
            val country = Country(lineArr[1], lineArr[0])
            repository.save(country)
        }
    }
}
