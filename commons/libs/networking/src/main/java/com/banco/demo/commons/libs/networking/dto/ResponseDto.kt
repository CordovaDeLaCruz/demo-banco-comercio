package com.banco.demo.commons.libs.networking.dto

data class ResponseDto<T>(
    var auditResponse: AuditResponseDto,
    var bodyResponse: T,
)
