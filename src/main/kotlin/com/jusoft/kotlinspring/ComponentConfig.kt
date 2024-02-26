package com.jusoft.kotlinspring

import com.jusoft.kotlinspring.component.MyComponent
import com.jusoft.kotlinspring.component.MyComponentRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ComponentConfig {

    @Bean
    fun myComponent(repo: MyComponentRepository): MyComponent {
        return MyComponent(repo)
    }
}
