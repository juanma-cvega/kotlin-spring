package com.jusoft.kotlinspring

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.testcontainers.containers.PostgreSQLContainer
import javax.sql.DataSource

@Configuration
class TestContainersConfig {

    @Bean
    @Profile("datasource-testcontainers")
    fun testcontainersDatasource(): DataSource {
        val postgres = PostgreSQLContainer("postgres:16.1").apply {
            withDatabaseName("sample")
            withUsername("toto")
            withPassword("toto")
            startupAttempts = 1
            withUrlParam("connectionTimeZone", "Z")
            withUrlParam("zeroDateTimeBehavior", "convertToNull")
        }
        postgres.start()

        val config = HikariConfig()
        config.password = postgres.password
        config.username = postgres.username
        config.jdbcUrl = postgres.jdbcUrl

        return HikariDataSource(config)
    }
}
