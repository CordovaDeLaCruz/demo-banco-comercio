package com.banco.demo.features.session.home.infraestructure.mapper

import com.banco.demo.commons.libs.networking.mapper.EntityMapper
import com.banco.demo.features.session.home.domain.entity.PersonDate
import com.banco.demo.features.session.home.infraestructure.dto.response.PersonDateResponseDto
import javax.inject.Inject

class PersonMapper
@Inject
constructor(): EntityMapper<PersonDateResponseDto, PersonDate> {

    override fun mapFromEntity(entity: PersonDateResponseDto): PersonDate {
        return PersonDate(
            id = entity.id,
            email = entity.email,
            name = entity.name,
            phone = entity.phone,
            username = entity.username,
            website = entity.website
        )
    }

    override fun mapToEntity(domainModel: PersonDate): PersonDateResponseDto {
        return PersonDateResponseDto(
            id = domainModel.id,
            email = domainModel.email,
            name = domainModel.name,
            phone = domainModel.phone,
            username = domainModel.username,
            website = domainModel.website
        )
    }

    fun mapFromEntityList(entities: List<PersonDateResponseDto>): List<PersonDate>{
        return entities.map { mapFromEntity(it) }
    }
}