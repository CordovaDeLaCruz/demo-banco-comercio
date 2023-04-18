package com.banco.demo.commons.libs.networking

import com.google.gson.Gson
import okhttp3.ResponseBody
import java.io.IOException
import java.lang.reflect.Type
import java.nio.charset.Charset

class ParseUtil {
    var gson = Gson()


    fun toJson(myClass: Any): String {
        return gson.toJson(myClass)
    }

    fun fromJson(json: String?, typeOfT: Type): Any? {
        return gson.fromJson<Type>(json, typeOfT)
    }


//    fun requestBodyToString(requestBody: RequestBody?): String? {
//        if (requestBody == null) {
//            return null
//        }
//        val source = requestBody.
//        return try {
//            source.request(Long.MAX_VALUE) // Buffer the entire body.
//            val buffer = source.buffer
//            buffer.clone().readString(Charset.defaultCharset())
//        } catch (e: IOException) {
//            e.printStackTrace()
//            null
//        }
//    }

    fun responseBodyToString(responseBody: ResponseBody?): String? {
        if (responseBody == null) {
            return null
        }
        val source = responseBody.source()
        return try {
            source.request(Long.MAX_VALUE) // Buffer the entire body.
            val buffer = source.buffer
            buffer.clone().readString(Charset.defaultCharset())
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

}