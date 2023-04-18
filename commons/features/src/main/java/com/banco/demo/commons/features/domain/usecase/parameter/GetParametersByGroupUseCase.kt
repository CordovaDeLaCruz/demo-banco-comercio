/* Banco Demo 2023 */
package com.banco.demo.commons.features.domain.usecase.parameter

import com.banco.demo.commons.domain.entity.Parameter
import com.banco.demo.commons.domain.entity.Response
import com.banco.demo.commons.features.domain.repository.ParameterRepository

class GetParametersByGroupUseCase constructor(private val repository: ParameterRepository) {

    companion object {
        const val GROUP_DOCUMENT: String = "documents"
    }

    suspend operator fun invoke(
        group: String,
        isRefresh: Boolean = false,
    ): Response<List<Parameter>> {
        return repository.getParametersByGroup(group, isRefresh)
    }

}
