package com.banco.demo.commons.libs.networking.mapper

import com.banco.demo.commons.domain.entity.Response
import com.banco.demo.commons.libs.networking.dto.AuditResponseDto
import com.banco.demo.commons.libs.networking.dto.ResponseDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResponseMapper<T> @Inject constructor() {


    fun mapFromModel(type: ResponseDto<T>?): Response<T>? {
        var item: Response<T>? = null
        if (type != null) item = Response(
            idTransaction = type.auditResponse.idTransaction,
            serviceName = type.auditResponse.serviceName,
            methodName = type.auditResponse.methodName,
            date = type.auditResponse.date,
            responseCode = type.auditResponse.responseCode,
            responseMessage = type.auditResponse.responseMessage,
            body = type.bodyResponse
        )
        return item
    }

    fun mapFromModel(auditResponse: AuditResponseDto?, body: T?): Response<T>? {
        var item: Response<T>? = null
        if (auditResponse != null) item = Response(
            idTransaction = auditResponse.idTransaction,
            serviceName = auditResponse.serviceName,
            methodName = auditResponse.methodName,
            date = auditResponse.date,
            responseCode = auditResponse.responseCode,
            responseMessage = auditResponse.responseMessage,
            body = body
        )
        return item
    }

//    fun mapToModel(type: Response<*>?): ResponseDto<*>? {
//        ("Not yet implemented")
//    }


}
