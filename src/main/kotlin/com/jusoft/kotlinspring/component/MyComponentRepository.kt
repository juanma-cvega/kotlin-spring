package com.jusoft.kotlinspring.component

interface MyComponentRepository {

    fun save(domainObject: MyDomainObject): Int
    fun find(id: Int): MyDomainObject?
}