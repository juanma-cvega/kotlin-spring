package com.jusoft.kotlinspring.persistence

import com.jusoft.kotlinspring.component.MyComponentRepository
import com.jusoft.kotlinspring.component.MyDomainObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MyComponentSpringRepositoryImpl(private val springRepo: MyComponentSpringBaseRepository): MyComponentRepository {
    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun save(domainObject: MyDomainObject): Int {
        log.info("Using spring framework")
        return springRepo.save(MyDomainSpringEntity(name = domainObject.name, surname = domainObject.surname)).id!!
    }

    override fun find(id: Int): MyDomainObject? {
        log.info("Using spring framework")
        return springRepo.findById(id)
            .map { entity -> MyDomainObject(entity.id, entity.name, entity.surname) }
            .orElse(null)
    }
}
