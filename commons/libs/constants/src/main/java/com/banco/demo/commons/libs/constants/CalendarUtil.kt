package com.banco.demo.commons.libs.constants

import java.text.SimpleDateFormat
import java.util.*

object CalendarUtil {

    fun getFormatDate(date: Date, format: String): String? {
        val dateFormat = SimpleDateFormat(format, Locale("es_ES"))
        return dateFormat.format(date)
    }


    fun getStringToDate(date: String, initFormat: String): Date? {
        var newDate: Date? = null
        try {
            val dateFormat = SimpleDateFormat(initFormat, Locale("es_ES"))
            newDate = dateFormat.parse(date)
        } catch (e: Exception) {
        }
        return newDate
    }

    fun getFormatDate(
        date: String,
        initFormat: String,
        endFormat: String,
    ): String? {
        try {
            val dateFormat = SimpleDateFormat(initFormat, Locale("" + ""))
            return getFormatDate(dateFormat.parse(date), endFormat)
        } catch (e: Exception) {
        }
        return date
    }
}