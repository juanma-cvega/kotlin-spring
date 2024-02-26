package com.jusoft.kotlinspring.persistence

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource

object DatasourceSingleton {

    var datasource: DataSource = config("jdbc:postgresql://localhost:5432/sample", "org.postgresql.Driver", "postgres", "postgres")

    private fun config(url: String, driver: String, username: String, password: String, ): DataSource {
        val config = HikariConfig()
        config.password = password
        config.username = username
        config.jdbcUrl = url
        config.driverClassName = driver
        return HikariDataSource(config)
    }
}
