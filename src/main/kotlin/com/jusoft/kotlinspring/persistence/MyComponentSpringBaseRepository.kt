package com.jusoft.kotlinspring.persistence

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MyComponentSpringBaseRepository: CrudRepository<MyDomainSpringEntity, Int>
