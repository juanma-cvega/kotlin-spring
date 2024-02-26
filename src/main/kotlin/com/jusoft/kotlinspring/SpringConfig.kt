package com.jusoft.kotlinspring

import com.jusoft.kotlinspring.component.MyComponentRepository
import com.jusoft.kotlinspring.persistence.MyComponentSpringBaseRepository
import com.jusoft.kotlinspring.persistence.MyComponentSpringRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import java.util.*
import javax.sql.DataSource

@Profile("spring")
@Configuration
@EnableJpaRepositories(
    basePackages = ["com.jusoft.kotlinspring.persistence"],
    entityManagerFactoryRef = "factoryEntityManager",
    transactionManagerRef = "factoryTransactionManager"
)
@EnableConfigurationProperties
class SpringConfig {

    @Autowired
    lateinit var source: DataSource

    @Bean
    fun factoryEntityManager(): LocalContainerEntityManagerFactoryBean {
        val properties = Properties()
        properties.setProperty("hibernate.hbm2ddl.auto", "create")
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
        properties.setProperty("generate-ddl", "true")
        properties.setProperty("show-sql", "true")
        return (LocalContainerEntityManagerFactoryBean()).apply {
            dataSource = source
            setJpaProperties(properties)
            setPackagesToScan("com.jusoft.kotlinspring.persistence")
            jpaVendorAdapter = HibernateJpaVendorAdapter()
        }
    }

    @Bean
    fun factoryTransactionManager() = JpaTransactionManager(factoryEntityManager().`object`!!)

    @Bean
    fun myComponentSpringRepository(springRepo: MyComponentSpringBaseRepository): MyComponentRepository {
        return MyComponentSpringRepositoryImpl(springRepo)
    }
}
