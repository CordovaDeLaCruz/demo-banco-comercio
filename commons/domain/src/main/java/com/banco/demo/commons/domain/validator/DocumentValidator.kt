package com.banco.demo.commons.domain.validator

import com.banco.demo.commons.domain.entity.Parameter

object DocumentValidator {

    fun getChangeDocumentType(documentType: String): ChangeDocumentType {
        var maxChar = -1
        var minChar = -1
        var isInputTypeNumber = false
        if (validateDocumentType(documentType))
            when (documentType) {
                Parameter.GROUP_DOCUMENT_DNI_DESCRIPTION -> {
                    maxChar = 8
                    minChar = 8
                    isInputTypeNumber = true
                }
                Parameter.GROUP_DOCUMENT_PASSPORT_DESCRIPTION -> {
                    minChar = 9
                    maxChar = 20
                    isInputTypeNumber = false
                }
                Parameter.GROUP_DOCUMENT_IMMIGRATION_DESCRIPTION -> {
                    minChar = 9
                    maxChar = 20
                    isInputTypeNumber = false
                }
            }
        return ChangeDocumentType(
            minChar = minChar,
            maxChar = maxChar,
            isInputTypeNumber = isInputTypeNumber
        )
    }

    fun validateDocumentType(documentType: String?): Boolean {
        var isValid = true
        if (documentType.isNullOrEmpty()) {
            isValid = false
        } else if (documentType.toInt() <= 0) {
            isValid = false
        }
        return isValid
    }

    fun validateDocumentNumber(documentType: String, documentNumber: String?): Boolean {
        var isValid = true
        if (documentNumber.isNullOrEmpty() || documentNumber.isNullOrBlank()) {
            isValid = false
        } else {
            when (documentType) {
                Parameter.GROUP_DOCUMENT_DNI_DESCRIPTION -> {
                    if (!NumberValidator.isNumeric(documentNumber)) {
                        isValid = false
                    } else if (documentNumber.length != 8) {
                        isValid = false
                    }
                }
                Parameter.GROUP_DOCUMENT_PASSPORT_DESCRIPTION -> {
                    if (documentNumber.length < 9 || documentNumber.length > 20) {
                        isValid = false
                    }
                }
                Parameter.GROUP_DOCUMENT_IMMIGRATION_DESCRIPTION -> {
                    if (documentNumber.length < 9 || documentNumber.length > 20) {
                        isValid = false
                    }
                }
            }
        }
        return isValid
    }
}