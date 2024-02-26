package com.jusoft.kotlinspring

import com.jusoft.kotlinspring.persistence.DatasourceSingleton
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.sql.DataSource

@Profile("local")
@Configuration
class LocalConfig {
    @Bean
    fun datasource(): DataSource {
        return DatasourceSingleton.datasource
    }
}
