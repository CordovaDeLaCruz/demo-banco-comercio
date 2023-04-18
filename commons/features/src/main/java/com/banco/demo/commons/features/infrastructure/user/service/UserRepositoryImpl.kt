/* Banco Demo 2023 */
package com.banco.demo.commons.features.infrastructure.user.service

import android.content.Context
import com.banco.demo.commons.domain.entity.Response
import com.banco.demo.commons.domain.entity.User
import com.banco.demo.commons.features.domain.entity.CheckReniecDataClient
import com.banco.demo.commons.features.domain.entity.ClientValidateDocument
import com.banco.demo.commons.features.domain.repository.UserRepository
import com.banco.demo.commons.features.util.DeviceUtil
import com.banco.demo.commons.libs.networking.mapper.ResponseMapper
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val context: Context,
    private val apiService: UserService,
    private val responseAuthenticateUser: ResponseMapper<User>,
    private val responseValidateDocumentMapper: ResponseMapper<ClientValidateDocument>,
    private val responseCheckReniecMapper: ResponseMapper<CheckReniecDataClient>
) : UserRepository {

    override suspend fun authenticateUser(
        documentType: String?,
        documentNumber: String?,
        password: String?,
        idRRSS: String?,
        typeRRSS: String?,
    ): Response<User> {
        var response: Response<User>?
        apiService.authenticateUser(documentType,
            documentNumber,
            password,
            DeviceUtil.getAndroidId(context),
            idRRSS,
            typeRRSS).also {
            response = responseAuthenticateUser.mapFromModel(
                type = it
            )
        }
        return response!!
    }

    override suspend fun validateDocumentClient(
        documentType: String?, documentNumber: String?,
        idRRSS: String?, typeRRSS: String?
    ): Response<ClientValidateDocument> {

        var response: Response<ClientValidateDocument>?
        apiService.validateDocumentClient(documentType, documentNumber, idRRSS, typeRRSS).also {
            response = responseValidateDocumentMapper.mapFromModel(
                type = it
            )
        }
        return response!!
    }

    override suspend fun checkReniecDataClient(documentNumber: String?): Response<CheckReniecDataClient> {
        var response: Response<CheckReniecDataClient>?
        apiService.checkReniecDataClient(documentNumber).also {
            response = responseCheckReniecMapper.mapFromModel(
                type = it
            )
        }
        return response!!
    }

}
