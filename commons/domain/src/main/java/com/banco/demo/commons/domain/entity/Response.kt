package com.banco.demo.commons.domain.entity

data class Response<T>(
    var idTransaction: String,
    var serviceName: String,
    var methodName: String,
    var date: String,
    var responseCode: String,
    var responseMessage: String,
    var body: T?,
)
