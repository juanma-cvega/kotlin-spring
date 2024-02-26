package com.jusoft.kotlinspring.component

import com.jusoft.kotlinspring.ComponentConfig
import com.jusoft.kotlinspring.SpringConfig
import com.jusoft.kotlinspring.TestContainersConfig
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration


@SpringBootTest
@ContextConfiguration(classes = [SpringConfig::class, TestContainersConfig::class, ComponentConfig::class])
abstract class MyComponentAbstractTest: FunSpec() {
    @Autowired
    private lateinit var myComponent: MyComponent

    fun myTest() {
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
