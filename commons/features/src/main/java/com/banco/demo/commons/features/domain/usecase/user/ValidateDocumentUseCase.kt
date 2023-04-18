/* Banco Demo 2023 */
package com.banco.demo.commons.features.domain.usecase.user

import com.banco.demo.commons.domain.entity.Response
import com.banco.demo.commons.domain.validator.DateValidator
import com.banco.demo.commons.domain.validator.DocumentValidator
import com.banco.demo.commons.features.domain.entity.ClientValidateDocument
import com.banco.demo.commons.features.domain.repository.UserRepository

class ValidateDocumentUseCase constructor(private val repository: UserRepository) {

    companion object {
        const  val  CODE_USER_NOT_EXIST = "1"
    }

    suspend operator fun invoke(
        documentType: String?, documentNumber: String?,
        idRRSS: String?, typeRRSS: String?
    ): Response<ClientValidateDocument> {

        return repository.validateDocumentClient(documentType, documentNumber, idRRSS, typeRRSS)
    }

    class InvalidValidateDocumentException(message: String) : Exception(message)

    fun isValidDocumentType(documentType: String): Boolean {
        return DocumentValidator.validateDocumentType(documentType = documentType)
    }

    fun isValidDocumentNumber(documentType: String, documentNumber: String): Boolean {
        return DocumentValidator.validateDocumentNumber(
            documentType = documentType,
            documentNumber = documentNumber
        )
    }

    fun isValidIssueDate(documentIssueDate: String): Boolean {
        return DateValidator.isDate(documentIssueDate)
    }

    fun isValidIssueDateFromInput(documentIssueDate: String): Boolean {
        return DateValidator.isDateFromInput(documentIssueDate)
    }

    sealed class Invalid {
        object DocumentType : Invalid()
        object DocumentNumber : Invalid()
        object DocumentIssueDate : Invalid()
    }


}
