package com.banco.demo.commons.domain.validator

object NumberValidator  {

    fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }

}