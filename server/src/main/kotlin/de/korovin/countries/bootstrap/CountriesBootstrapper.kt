package de.korovin.countries.bootstrap

import de.korovin.countries.services.CountryBootstrapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component



/**
 * Created by aw3s0 on 10/11/2017.
 * Loads countries from URL on ContextRefereshedEvent
 */
@Component
class CountriesBootstrapper(
        private @Autowired val service: CountryBootstrapService
): ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(event: ContextRefreshedEvent?) {
        service.bootstrap()
    }
}
