package com.jusoft.kotlinspring.component


import io.kotest.extensions.spring.SpringExtension
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles(profiles = ["exposed","datasource-testcontainers"])
class MyComponentExposedTest : MyComponentAbstractTest() {
    init {
        extension(SpringExtension)

        this.test("Connect to the testcontainers database") {
            databaseAccessTest()
        }
    }
}
