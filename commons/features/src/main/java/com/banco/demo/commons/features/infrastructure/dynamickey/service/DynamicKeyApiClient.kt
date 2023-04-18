/* Banco Demo 2023 */
package com.banco.demo.commons.features.infrastructure.dynamickey.service

import com.banco.demo.commons.features.domain.entity.GenerateDynamicKey
import com.banco.demo.commons.features.domain.entity.ValidateDynamicKey
import com.banco.demo.commons.features.infrastructure.dto.request.*
import com.banco.demo.commons.libs.networking.dto.ResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface DynamicKeyApiClient {

    @POST("/v1/otp/pin/generation")
    suspend fun generateDynamicKey(@Body requestBody: GenerateDynamicKeyRequestDto): Response<ResponseDto<GenerateDynamicKey>>

    @POST("/v1/otp/pin/validation")
    suspend fun validateDynamicKey(@Body requestBody: ValidateDynamicKeyRequestDto): Response<ResponseDto<ValidateDynamicKey>>
}
