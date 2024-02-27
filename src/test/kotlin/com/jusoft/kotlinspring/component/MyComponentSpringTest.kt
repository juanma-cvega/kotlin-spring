package com.jusoft.kotlinspring.component


import io.kotest.extensions.spring.SpringExtension
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles(profiles = ["spring","datasource-testcontainers"])
class MyComponentSpringTest : MyComponentAbstractTest() {
    init {
        extension(SpringExtension)

        this.test("Connect to the testcontainers database") {
            databaseAccessTest()
        }
    }
}
