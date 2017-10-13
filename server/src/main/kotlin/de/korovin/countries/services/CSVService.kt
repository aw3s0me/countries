package de.korovin.countries.services

import com.opencsv.CSVWriter
import com.opencsv.bean.StatefulBeanToCsvBuilder
import org.springframework.stereotype.Service
import java.io.StringWriter

/**
 * Created by aw3s0 on 10/12/2017.
 * Service to convert data to CSV format
 */
@Service
class CSVService {
    /**
     * Converts list of beans to csv string
     */
    fun <T> convertList(list: MutableList<T>): String {
        StringWriter().use { writer ->
            CSVWriter(writer).use {
                val beanToCsv = StatefulBeanToCsvBuilder<T>(writer).build()
                beanToCsv.write(list)
                return writer.toString()
            }
        }
    }
}
