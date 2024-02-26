package com.jusoft.kotlinspring.persistence

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class MyDomainEntity(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<MyDomainEntity>(MyDomainTable)

    var name by MyDomainTable.name
    var surname by MyDomainTable.surname
}