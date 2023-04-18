/* Banco Demo 2023 */
package com.banco.demo.commons.features.domain.usecase.user

import com.banco.demo.commons.domain.entity.Response
import com.banco.demo.commons.domain.entity.User
import com.banco.demo.commons.domain.validator.DocumentValidator
import com.banco.demo.commons.domain.validator.UtilValidator
import com.banco.demo.commons.features.domain.repository.UserRepository

class LoginUseCase constructor(private val repository: UserRepository) {

    suspend operator fun invoke(
        documentType: String?, documentNumber: String?,
        password: String?,
        idRRSS: String?, typeRRSS: String?,
    ): Response<User> {

        return repository.authenticateUser(documentType,
            documentNumber,
            password,
            idRRSS,
            typeRRSS)
    }

    class InvalidLoginException(message: String) : Exception(message)


    fun isValidDocumentType(documentType: String): Boolean {
        return DocumentValidator.validateDocumentType(documentType = documentType)
    }

    fun isValidDocumentNumber(documentType: String, documentNumber: String): Boolean {
        return DocumentValidator.validateDocumentNumber(
            documentType = documentType,
            documentNumber = documentNumber
        )
    }

    fun isValidPassword(password: String): Boolean {
        return UtilValidator.isValidPassword(password = password)
    }

}
