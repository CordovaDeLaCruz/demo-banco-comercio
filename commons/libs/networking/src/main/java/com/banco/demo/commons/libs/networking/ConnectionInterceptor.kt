package com.banco.demo.commons.libs.networking

import android.content.Context
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.crashlytics.ktx.setCustomKeys
import com.google.firebase.ktx.Firebase
import com.banco.demo.commons.libs.networking.dto.ResponseDto
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import java.io.IOException

class ConnectionInterceptor(var context: Context) : Interceptor {


    private companion object {
        const val HEADER_CHANNEL_NAME = "channel"
        const val HEADER_VALUE_CHANNEL = "ANDROID"
        const val HEADER_NAME_ID_TRANSACTION = "idTransaction"
    }

    private var parseUtil = ParseUtil()


    override fun intercept(chain: Interceptor.Chain): Response {

        //Validación si esta online o no los datos.

        //En caso se desea modificar el request
        var url = ""

        try {
            val networkingApp: NetworkingApp =
                context.applicationContext as NetworkingApp
            val idTransaction: String = networkingApp.getIdTransaction()

            val request = chain.request()

            val builder = request.newBuilder()
                .addHeader("Content-Type", "application/json; charset=UTF-8")
                .addHeader("Accept", "application/json")
                .addHeader(HEADER_CHANNEL_NAME, HEADER_VALUE_CHANNEL)
                .addHeader(HEADER_NAME_ID_TRANSACTION, idTransaction)

            val newRequest = builder.build()

            val requestTime = System.currentTimeMillis()
            url = newRequest.url.toString()
            val requestBodyToString = convertRequestToString(request)

            FirebaseCrashlytics.getInstance().log("--> ${newRequest.method} ${newRequest.url}")
            FirebaseCrashlytics.getInstance().log("Headers:\n${newRequest.headers}")
            FirebaseCrashlytics.getInstance().log(
                "Body:\n${requestBodyToString ?: ""}")
//            Log.i("ConnectionInterceptor",
//                "Body:\n${parseUtil.requestBodyToString(newRequest.body)}")
            FirebaseCrashlytics.getInstance().log("--> END ${newRequest.method}")

            //En caso se desea modificar la respuesta.
            val response = chain.proceed(newRequest)

            val responseTime = System.currentTimeMillis()

            val responseBodyToString = parseUtil.responseBodyToString(response.body)

            FirebaseCrashlytics.getInstance()
                .log("--> ${response.code} ${response.message} ${response.request.url} (${responseTime - requestTime}ms)")
            FirebaseCrashlytics.getInstance().log("Headers:\n${response.headers}")
            FirebaseCrashlytics.getInstance().log("Body:\n${responseBodyToString ?: ""}")
            FirebaseCrashlytics.getInstance().log("<-- END HTTP")



            val crashlytics = Firebase.crashlytics
            crashlytics.setCustomKeys {
                key("service_url", url)
                key("service_response_code", response.code)
                key("service_error", false)
            }
            FirebaseCrashlytics.getInstance().recordException(Exception(url))

            val responseDto: ResponseDto<*>? = convertToResponseDto(responseBodyToString)

            when (response.code) {
                HttpCode.OK -> {
                    if (responseDto != null) {
                        networkingApp.setIdTransaction(responseDto.auditResponse.idTransaction)
//                    if (responseDto.auditResponse.responseCode == AuditResponseDto.SUCCESS) {
                        return response
//                    } else {
//                        throw NetworkException(
//                            code = responseDto.auditResponse.responseCode,
//                            message = responseDto.auditResponse.responseMessage
//                        )
//                    }
                    } else {
                        throw NetworkException(
                            code = NetworkException.ERROR_GENERAL,
                            message = ""
                        )
                    }
                }
                else -> {
                    throw  if (responseDto == null) {
                        NetworkException(
                            code = NetworkException.ERROR_GENERAL,
                            message = ""
                        )
                    } else {
                        NetworkException(
                            code = responseDto.auditResponse.responseCode,
                            message = responseDto.auditResponse.responseMessage
                        )
                    }
                }
            }

        } catch (e: IOException) {
            FirebaseCrashlytics.getInstance().log("<-- HTTP FAILED: ${e.message}")
            val crashlytics = Firebase.crashlytics
            crashlytics.setCustomKeys {
                key("service_url", url)
                key("service_response_code", "ERROR")
                key("service_error", true)
            }
            FirebaseCrashlytics.getInstance().recordException(Exception(url))
            throw NetworkException(
                code = NetworkException.ERROR_GENERAL,
                message = ""
            )
        }



    }

    private fun convertRequestToString(request: Request): String? {
        return try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            copy.body!!.writeTo(buffer)
            buffer.readUtf8()
        } catch (e: IOException) {
            null
        } catch (e: Exception) {
            null
        }

    }

    private fun convertToResponseDto(responseBody: ResponseBody?): ResponseDto<*>? {
        var responseDto: ResponseDto<*>?
        try {
            val bodyToString: String? = parseUtil.responseBodyToString(responseBody)
            responseDto = parseUtil.fromJson(bodyToString,
                ResponseDto::class.java) as ResponseDto<*>?
            if (responseDto?.auditResponse == null) {
                responseDto = null
            }
        } catch (e: Exception) {
            responseDto = null
        }
        return responseDto
    }


    private fun convertToResponseDto(bodyToString: String?): ResponseDto<*>? {
        var responseDto: ResponseDto<*>?
        try {
            responseDto = parseUtil.fromJson(bodyToString,
                ResponseDto::class.java) as ResponseDto<*>?
            if (responseDto?.auditResponse == null) {
                responseDto = null
            }
        } catch (e: Exception) {
            responseDto = null
        }
        return responseDto
    }


}