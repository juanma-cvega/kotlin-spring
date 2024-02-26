package com.jusoft.kotlinspring.persistence

import org.jetbrains.exposed.dao.id.IntIdTable

object MyDomainTable: IntIdTable("USERS") {
    val name = varchar("name", 50)
    val surname = varchar("surname", 50)
}