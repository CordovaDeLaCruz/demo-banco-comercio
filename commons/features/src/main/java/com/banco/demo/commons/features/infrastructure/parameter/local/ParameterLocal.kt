/* Banco Demo 2023 */
package com.banco.demo.commons.features.infrastructure.parameter.local

import com.banco.demo.commons.features.infrastructure.dto.ParameterDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ParameterLocal @Inject constructor(private val parameterDao: ParameterDao) {

    suspend fun getParameters(): List<ParameterDto> {
        return withContext(Dispatchers.IO) {
            parameterDao.getParameters()
        }
    }

    suspend fun getParametersByGroup(group: String): List<ParameterDto> {
        return withContext(Dispatchers.IO) {
            parameterDao.getParametersByGroup(group)
        }
    }

    suspend fun nukeTable() {
        return withContext(Dispatchers.IO) {
            parameterDao.nukeTable()
        }
    }

    suspend fun insertAllParameters(parameters: List<ParameterDto?>?) {
        return withContext(Dispatchers.IO) {
            parameterDao.insertAllParameter(parameters)
        }
    }
}
