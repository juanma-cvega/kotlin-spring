package com.jusoft.kotlinspring.component


import io.kotest.extensions.spring.SpringExtension

class MyComponentTest : MyComponentAbstractTest() {
    init {
        extension(SpringExtension)

        this.test("Connect to the testcontainers database") {
            databaseAccessTest()
        }
    }
}
