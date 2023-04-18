package com.banco.demo.commons.domain.util

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object DateFormat {

    fun formatToInputText(dateStr: String): String {
        return try {
            val formatter = SimpleDateFormat("ddMMyyyy", Locale.getDefault())
            formatter.isLenient = false
            val date = formatter.parse(dateStr)
            val formatterNew = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            formatterNew.isLenient = false
            formatterNew.format(date)
        } catch (e: Exception) {
            ""
        }

    }
}