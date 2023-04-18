package com.banco.demo.commons.domain.validator

import java.util.regex.Pattern

object UtilValidator {

    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    val PASSWORD_PATTERN = Pattern.compile(
        "^(?=\\w*\\d)(?=\\w*[A-Z])\\S{6,8}\$"
    )

    val PHONE_PATTERN = Pattern.compile(
        "^9[0-9]{8}"
    )

    val DATE_ISSUE_PATTERN = Pattern.compile(
        "^([0-2][0-9]|3[0-1])(0[1-9]|1[0-2])((19|20)[0-9]{2})\$"
    )

    fun isTextNotNullAndNotEmptyAndNotBlank(
        value: String?
    ): Boolean {
        var isValid = true
        if (value.isNullOrEmpty() || value.isNullOrBlank()) {
            isValid = false
        }
        return isValid
    }

    fun isValidEmail(email: String?): Boolean {
        var isValid = true
        if (!isTextNotNullAndNotEmptyAndNotBlank(email)) {
            isValid = false
        }
        if (isValid && !EMAIL_ADDRESS_PATTERN.matcher(email).matches()) {
            isValid = false
        }
        return isValid
    }

    fun isValidPassword(password: String?): Boolean {
        var isValid = true
        if (!isTextNotNullAndNotEmptyAndNotBlank(password)) {
            isValid = false
        }
        if (isValid && !PASSWORD_PATTERN.matcher(password).matches()) {
            isValid = false
        }
        return isValid
    }

    fun isValidPhone(password: String?): Boolean {
        var isValid = true
        if (!isTextNotNullAndNotEmptyAndNotBlank(password)) {
            isValid = false
        }
        if (isValid && !PHONE_PATTERN.matcher(password).matches()) {
            isValid = false
        }
        return isValid
    }

    fun isValidDateIssue(dateIssue: String?): Boolean {
        var isValid = true
        if (!isTextNotNullAndNotEmptyAndNotBlank(dateIssue)) {
            isValid = false
        }
        if (isValid && !DATE_ISSUE_PATTERN.matcher(dateIssue).matches()) {
            isValid = false
        }
        return isValid
    }
}