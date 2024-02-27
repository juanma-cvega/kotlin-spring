package com.jusoft.kotlinspring.component


import io.kotest.extensions.spring.SpringExtension
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles(profiles = ["exposed","datasource-config"])
class MyComponentLocalTest : MyComponentAbstractTest() {
    init {
        extension(SpringExtension)

        this.test("Connect to the testcontainers database") {
            databaseAccessTest()
        }
    }
}
