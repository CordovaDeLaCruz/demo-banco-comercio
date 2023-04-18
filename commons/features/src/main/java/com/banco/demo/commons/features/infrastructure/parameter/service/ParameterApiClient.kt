/* Banco Demo 2023 */
package com.banco.demo.commons.features.infrastructure.parameter.service

import com.banco.demo.commons.features.infrastructure.dto.response.GetParametersResponseDto
import com.banco.demo.commons.libs.networking.dto.ResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ParameterApiClient {

    @GET("https://7c66227a-6433-44b4-89d2-c2ad1c329e32.mock.pstmn.io/v1/additionalParameters/{group}")
    suspend fun getParameters(@Path("group") group: String): Response<ResponseDto<GetParametersResponseDto>>


}
