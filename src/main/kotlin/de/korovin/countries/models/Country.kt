package de.korovin.countries.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by aw3s0 on 10/10/2017.
 * Model for storing countries
 */
@Entity
class Country(var name: String, var shortName: String) {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
}
