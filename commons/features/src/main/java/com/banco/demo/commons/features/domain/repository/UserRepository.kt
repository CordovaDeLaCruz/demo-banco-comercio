/* Banco Demo 2023 */
package com.banco.demo.commons.features.domain.repository

import com.banco.demo.commons.domain.entity.Response
import com.banco.demo.commons.domain.entity.User
import com.banco.demo.commons.features.domain.entity.CheckReniecDataClient
import com.banco.demo.commons.features.domain.entity.ClientValidateDocument


interface UserRepository {

    suspend fun authenticateUser(
        documentType: String?,
        documentNumber: String?,
        password: String?,
        idRRSS: String?,
        typeRRSS: String?,
    ): Response<User>


    suspend fun validateDocumentClient(
        documentType: String?, documentNumber: String?,
        idRRSS: String?, typeRRSS: String?,
    ): Response<ClientValidateDocument>

    suspend fun checkReniecDataClient(
        documentNumber: String?,
    ): Response<CheckReniecDataClient>

}
