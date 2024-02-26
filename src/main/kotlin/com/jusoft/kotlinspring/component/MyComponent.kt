package com.jusoft.kotlinspring.component

class MyComponent(private val repository: MyComponentRepository) {

    fun createObject(domainObject: MyDomainObject) : Int{
        return repository.save(domainObject)
    }

    fun findObject(id: Int): MyDomainObject? {
        return repository.find(id)
    }
}