package com.banco.demo.commons.domain.validator

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object DateValidator {

    fun isDate(dateStr: String): Boolean {
        return try {
            val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            formatter.isLenient = false
            formatter.parse(dateStr)
            true
        } catch (e: Exception) {
            false
        }

    }

    fun isDateFromInput(dateStr: String): Boolean {
        return try {
            val formatter = SimpleDateFormat("ddMMyyyy", Locale.getDefault())
            formatter.isLenient = false
            formatter.parse(dateStr)
            true
        } catch (e: Exception) {
            false
        }

    }


}