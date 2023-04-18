/* Banco Demo 2023 */
package com.banco.demo.commons.features.infrastructure.dto.request

data class LoginUserRequestDto(
    val documentType: String?,
    val documentNumber: String?,
    val password: String?,
    val deviceId: String?,
    val idRRSS: String?,
    val typeRRSS: String?
)
