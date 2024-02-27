package com.jusoft.kotlinspring.component

import com.jusoft.kotlinspring.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration


@SpringBootTest
@EnableConfigurationProperties
@ContextConfiguration(classes = [DatasourceConfig::class, ComponentConfig::class, ExposedConfig::class, SpringConfig::class, TestContainersConfig::class])
abstract class MyComponentAbstractTest: FunSpec() {
    @Autowired
    private lateinit var myComponent: MyComponent

    fun databaseAccessTest() {
        val name = "toto"
        val surname = "toto"

        val createdObject = myComponent.createObject(MyDomainObject(name = name, surname = surname))
        val foundObject = myComponent.findObject(createdObject)

        foundObject.shouldNotBeNull()
        foundObject.id!!.shouldBeExactly(createdObject)
        foundObject.name shouldBe name
        foundObject.surname shouldBe surname
    }
}
