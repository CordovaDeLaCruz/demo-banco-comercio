/* Banco Demo 2023 */
package com.banco.demo.commons.libs.networking.dto

data class AuditResponseDto(
    var idTransaction: String,
    var serviceName: String,
    var methodName: String,
    var date: String,
    var responseCode: String,
    var responseMessage: String,
) {
 
}
