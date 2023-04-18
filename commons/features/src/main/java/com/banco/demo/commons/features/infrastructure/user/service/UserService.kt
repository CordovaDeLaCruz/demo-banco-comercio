/* Banco Demo 2023 */
package com.banco.demo.commons.features.infrastructure.user.service

import com.banco.demo.commons.domain.entity.User
import com.banco.demo.commons.features.domain.entity.CheckReniecDataClient
import com.banco.demo.commons.features.domain.entity.ClientValidateDocument
import com.banco.demo.commons.features.infrastructure.dto.request.CheckReniecDataClientRequestDto
import com.banco.demo.commons.features.infrastructure.dto.request.LoginUserRequestDto
import com.banco.demo.commons.features.infrastructure.dto.request.ValidateDocumentClientRequestDto
import com.banco.demo.commons.libs.networking.dto.ResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserService @Inject constructor(private val retrofit: Retrofit) {


    suspend fun authenticateUser(
        documentType: String?, documentNumber: String?,
        password: String?, deviceId: String?,
        idRRSS: String?, typeRRSS: String?
    ): ResponseDto<User> {
        return withContext(Dispatchers.IO) {
            val loginUserRequest =
                LoginUserRequestDto(documentType, documentNumber, password, deviceId, idRRSS, typeRRSS)
            val response = retrofit.create(UserApiClient::class.java).authenticateUser(loginUserRequest)
            response.body()!!
        }
    }

    suspend fun validateDocumentClient(
        documentType: String?, documentNumber: String?,
        idRRSS: String?, typeRRSS: String?
    ): ResponseDto<ClientValidateDocument> {
        return withContext(Dispatchers.IO) {
            val validateDocumentClientRequest =
                ValidateDocumentClientRequestDto(documentType, documentNumber, idRRSS, typeRRSS)
            val response = retrofit.create(UserApiClient::class.java)
                .validateDocumentClient(validateDocumentClientRequest)
            response.body()!!
        }
    }

    suspend fun checkReniecDataClient(documentNumber: String?,
    ): ResponseDto<CheckReniecDataClient> {
        return withContext(Dispatchers.IO) {
            val checkReniecDocumentClientRequest =
                CheckReniecDataClientRequestDto(documentNumber)
            val response = retrofit.create(UserApiClient::class.java)
                .checkReniecDataClient(checkReniecDocumentClientRequest)
            response.body()!!
        }
    }

}
