package com.jusoft.kotlinspring.component


import com.jusoft.kotlinspring.ComponentConfig
import com.jusoft.kotlinspring.SpringConfig
import com.jusoft.kotlinspring.TestContainersConfig
import io.kotest.extensions.spring.SpringExtension
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ActiveProfiles(profiles = ["spring","testcontainers"])
@ContextConfiguration(classes = [SpringConfig::class, TestContainersConfig::class, ComponentConfig::class])
@EntityScan(basePackages = ["com.jusoft.persistence"])
class MyComponentSpringTest : MyComponentAbstractTest() {
    init {
        extension(SpringExtension)

        this.test("Connect to the testcontainers database") {
            myTest()
        }
    }
}
