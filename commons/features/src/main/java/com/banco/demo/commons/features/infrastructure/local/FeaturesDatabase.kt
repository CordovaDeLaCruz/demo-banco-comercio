package com.banco.demo.commons.features.infrastructure.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.banco.demo.commons.features.infrastructure.dto.ParameterDto
import com.banco.demo.commons.features.infrastructure.parameter.local.ParameterDao

@Database(
    entities = [ParameterDto::class],
    version = 1,
    exportSchema = true
)
abstract class FeaturesDatabase : RoomDatabase() {

    abstract val parameterDao: ParameterDao

    companion object {
        const val DATABASE_NAME = "features_db"
    }
}