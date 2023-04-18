/* Banco Demo 2023 */
package com.banco.demo.commons.features.infrastructure.parameter

import com.banco.demo.commons.domain.entity.Parameter
import com.banco.demo.commons.domain.entity.Response
import com.banco.demo.commons.features.domain.repository.ParameterRepository
import com.banco.demo.commons.features.infrastructure.dto.mapper.ParameterMapper
import com.banco.demo.commons.features.infrastructure.parameter.local.ParameterLocal
import com.banco.demo.commons.features.infrastructure.parameter.service.ParameterService
import com.banco.demo.commons.libs.constants.Strings.SERVICE_CODE_SUCCESS
import com.banco.demo.commons.libs.networking.dto.AuditResponseDto
import com.banco.demo.commons.libs.networking.mapper.ResponseMapper
import javax.inject.Inject

class ParameterRepositoryImpl @Inject constructor(
    private val apiService: ParameterService,
    private val daoLocal: ParameterLocal,
    private val responseGetParametersMapper: ResponseMapper<List<Parameter>>,
    private val parameterMapper: ParameterMapper,
) : ParameterRepository {

    override suspend fun getParametersByGroup(
        group: String,
        isRefresh: Boolean,
    ): Response<List<Parameter>> {
        var response: Response<List<Parameter>>? = null
        var isRefreshAux = isRefresh

        if (!isRefreshAux) {
            val parameters = daoLocal.getParametersByGroup(group)
            if (parameters.isEmpty()) {
                isRefreshAux = true
            } else {
                val auditResponseDto = AuditResponseDto(
                    "",
                    "",
                    "",
                    "",
                    SERVICE_CODE_SUCCESS,
                    "",

                    )
                response = responseGetParametersMapper.mapFromModel(
                    auditResponse = auditResponseDto,
                    body = parameterMapper.mapFromModel(parameters)
                )
            }
        }

        if (isRefreshAux)
            apiService.getParameters(group).also {
                if (it.auditResponse.responseCode == "0") {
                    daoLocal.nukeTable()
                    daoLocal.insertAllParameters(it.bodyResponse.parameters)

                }
                response = responseGetParametersMapper.mapFromModel(
                    auditResponse = it.auditResponse,
                    body = parameterMapper.mapFromModel(it.bodyResponse.parameters)
                )
            }

        return response!!
    }


}
