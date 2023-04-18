/* Banco Demo 2023 */
package com.banco.demo.commons.features.infrastructure.dto.request

data class ValidateDocumentClientRequestDto(
    val documentType: String?,
    val documentNumber: String?,
    val idRRSS: String?,
    val typeRRSS: String?
)
