/* Banco Demo 2023 */
package com.banco.demo.commons.features.infrastructure.parameter.service

import com.banco.demo.commons.features.infrastructure.dto.response.GetParametersResponseDto
import com.banco.demo.commons.libs.networking.dto.ResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ParameterService @Inject constructor(private val retrofit: Retrofit) {

    suspend fun getParameters(group: String): ResponseDto<GetParametersResponseDto> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ParameterApiClient::class.java).getParameters(group)
            response.body()!!
        }
    }
}
