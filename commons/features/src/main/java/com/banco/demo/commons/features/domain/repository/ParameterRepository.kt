/* Banco Demo 2023 */
package com.banco.demo.commons.features.domain.repository

import com.banco.demo.commons.domain.entity.Parameter
import com.banco.demo.commons.domain.entity.Response


interface ParameterRepository {

    suspend fun getParametersByGroup(
        group: String,
        isRefresh: Boolean = false,
    ): Response<List<Parameter>>
}
