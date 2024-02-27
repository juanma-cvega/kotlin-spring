package com.jusoft.kotlinspring

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.sql.DataSource

@Configuration
class DatasourceConfig {
    @Profile("datasource-config")
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    fun configDatasource(): DataSource = DataSourceBuilder.create().build()

}
