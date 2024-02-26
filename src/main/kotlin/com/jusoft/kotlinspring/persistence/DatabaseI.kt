package com.jusoft.kotlinspring.persistence

import org.jetbrains.exposed.sql.Database

interface DatabaseI {

    fun get():Database
}