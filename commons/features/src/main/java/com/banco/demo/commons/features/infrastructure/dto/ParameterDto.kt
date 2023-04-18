package com.banco.demo.commons.features.infrastructure.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parameters")
data class ParameterDto(
    val description: String,
    val value: String,
    val group: String,
    @PrimaryKey val id: Int? = null,
)
