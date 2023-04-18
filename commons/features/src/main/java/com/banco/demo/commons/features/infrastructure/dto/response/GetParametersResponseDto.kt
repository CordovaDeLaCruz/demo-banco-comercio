/* Banco Demo 2023 */
package com.banco.demo.commons.features.infrastructure.dto.response

import com.banco.demo.commons.features.infrastructure.dto.ParameterDto

data class GetParametersResponseDto(
    var parameters: List<ParameterDto>,
)
