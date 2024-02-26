package com.jusoft.kotlinspring

import com.jusoft.kotlinspring.component.MyComponent
import com.jusoft.kotlinspring.component.MyComponentRepository
import com.jusoft.kotlinspring.persistence.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.sql.DataSource

@Profile("exposed")
@Configuration
class ExposedConfig {

    @Bean
    fun myComponentExposedRepository(dataSource: DataSource): MyComponentRepository {
        return MyComponentExposedRepository(dataSource)
    }

}
