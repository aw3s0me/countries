package de.korovin.countries.helpers

import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

/**
 * Created by aw3s0 on 10/11/2017.
 * Helper class to fetch data from urls
 */
@Component
class UrlOpener {
    fun fetchStreamFromUrl(url: String): BufferedReader {
        // read file from internet
        val countriesURL = URL(url)
        val stream = countriesURL.openStream()
        return BufferedReader(InputStreamReader(stream))
    }
}
