package com.jusoft.kotlinspring

import com.jusoft.kotlinspring.persistence.DatasourceSingleton
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.context.annotation.PropertySource
import javax.sql.DataSource

@Configuration
class DatasourceConfig {
    @Profile("datasource-config")
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    fun configDatasource(): DataSource = DataSourceBuilder.create().build()

    @Profile("datasource-fixed")
    @Bean
    fun fixedDatasource(): DataSource {
        return DatasourceSingleton.datasource
    }
}
