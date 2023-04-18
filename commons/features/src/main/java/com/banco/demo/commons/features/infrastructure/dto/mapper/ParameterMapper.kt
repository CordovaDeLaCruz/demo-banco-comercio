package com.banco.demo.commons.features.infrastructure.dto.mapper

import com.banco.demo.commons.domain.entity.Parameter
import com.banco.demo.commons.features.infrastructure.dto.ParameterDto
import com.banco.demo.commons.libs.networking.mapper.Mapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ParameterMapper @Inject constructor() : Mapper<ParameterDto, Parameter>() {

    override fun mapFromModel(type: ParameterDto?): Parameter? {
        var item: Parameter? = null
        if (type != null) {
            item = Parameter(
                description = type.description,
                value = type.value,
                group = type.group
            )
        }
        return item
    }

    override fun mapToModel(type: Parameter?): ParameterDto? {
        var item: ParameterDto? = null
        if (type != null) {
            item = ParameterDto(
                description = type.description,
                value = type.value,
                group = type.group
            )
        }
        return item
    }
}