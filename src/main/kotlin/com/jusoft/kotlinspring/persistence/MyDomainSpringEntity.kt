package com.jusoft.kotlinspring.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "MyDomainObjects")
class MyDomainSpringEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @Column(nullable = false, length = 100)
    var name: String,
    @Column(nullable = false, length = 100)
    var surname: String
)
