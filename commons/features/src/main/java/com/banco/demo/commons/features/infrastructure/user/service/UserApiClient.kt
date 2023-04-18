/* Banco Demo 2023 */
package com.banco.demo.commons.features.infrastructure.user.service

import com.banco.demo.commons.domain.entity.User
import com.banco.demo.commons.features.domain.entity.CheckReniecDataClient
import com.banco.demo.commons.features.domain.entity.ClientValidateDocument
import com.banco.demo.commons.features.infrastructure.dto.request.CheckReniecDataClientRequestDto
import com.banco.demo.commons.features.infrastructure.dto.request.LoginUserRequestDto
import com.banco.demo.commons.features.infrastructure.dto.request.ValidateDocumentClientRequestDto
import com.banco.demo.commons.libs.networking.dto.ResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiClient {
    @POST("/users/validation")
    suspend fun validateDocumentClient(@Body requestBody: ValidateDocumentClientRequestDto): Response<ResponseDto<ClientValidateDocument>>


    @POST("/users/authentication")
    suspend fun authenticateUser(@Body requestBody: LoginUserRequestDto): Response<ResponseDto<User>>

    @POST("/v1/reniec/validatePerson")
    suspend fun checkReniecDataClient(@Body requestBody: CheckReniecDataClientRequestDto): Response<ResponseDto<CheckReniecDataClient>>
}
