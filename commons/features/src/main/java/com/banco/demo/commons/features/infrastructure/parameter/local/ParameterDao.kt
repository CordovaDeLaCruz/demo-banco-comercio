package com.banco.demo.commons.features.infrastructure.parameter.local

import androidx.room.*
import com.banco.demo.commons.features.infrastructure.dto.ParameterDto


@Dao
interface ParameterDao {

    @Query("SELECT * FROM parameters")
    fun getParameters(): List<ParameterDto>

    @Query("DELETE FROM parameters")
    fun nukeTable()

    @Query("SELECT * FROM parameters WHERE `group` = :group")
    fun getParametersByGroup(group: String): List<ParameterDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParameter(parameter: ParameterDto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllParameter(parameters: List<ParameterDto?>?)

    @Delete
    suspend fun deleteParameter(parameter: ParameterDto)
}