package com.jusoft.kotlinspring.persistence

import com.jusoft.kotlinspring.component.MyDomainObject
import com.jusoft.kotlinspring.component.MyComponentRepository
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.sql.DataSource

class MyComponentExposedRepository(private val datasource: DataSource): MyComponentRepository {
    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun save(domainObject: MyDomainObject) : Int {
        log.info("Using exposed framework")
        Database.connect(datasource)
        return transaction {
            SchemaUtils.create(MyDomainTable)
            MyDomainEntity.new {
                name = domainObject.name
                surname = domainObject.surname
            }.id.value
        }
    }

    override fun find(id: Int): MyDomainObject? {
        log.info("Using exposed framework")
        Database.connect(datasource)
        return transaction {
            MyDomainEntity.findById(id)?.let { MyDomainObject(it.id.value, it.name, it.surname) }
        }
    }
}
