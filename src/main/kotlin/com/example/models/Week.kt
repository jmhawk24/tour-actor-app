package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Week (val id: Int, val startsAt: String, val endsAt: String)

object Weeks : Table() {
    val id = integer("id").autoIncrement()
    val startsAt = varchar("startsAt", 10)
    val endsAt = varchar("endsAt", 10)

    override val primaryKey = PrimaryKey(id)
}