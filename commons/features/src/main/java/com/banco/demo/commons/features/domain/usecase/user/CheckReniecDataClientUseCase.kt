/* Banco Demo 2023 */
package com.banco.demo.commons.features.domain.usecase.user

import com.banco.demo.commons.domain.entity.Response
import com.banco.demo.commons.domain.validator.DocumentValidator
import com.banco.demo.commons.features.domain.entity.CheckReniecDataClient
import com.banco.demo.commons.features.domain.repository.UserRepository

class CheckReniecDataClientUseCase constructor(private val repository: UserRepository) {

    suspend operator fun invoke(documentNumber: String?
    ): Response<CheckReniecDataClient> {

        return repository.checkReniecDataClient(documentNumber)
    }

    class InvalidValidateDocumentException(message: String) : Exception(message)

    fun isValidDocumentNumber(documentType: String, documentNumber: String): Boolean {
        return DocumentValidator.validateDocumentNumber(
            documentType = documentType,
            documentNumber = documentNumber
        )
    }

    sealed class Invalid {
        object DocumentNumber : Invalid()
    }


}
