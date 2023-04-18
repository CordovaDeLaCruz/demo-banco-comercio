package com.banco.demo.features.session.home.infraestructure.mapper

import com.banco.demo.commons.libs.networking.mapper.EntityMapper
import com.banco.demo.features.session.home.domain.entity.CreatePostResponse
import com.banco.demo.features.session.home.domain.entity.Post
import com.banco.demo.features.session.home.infraestructure.dto.response.CreatePostResponseDto
import com.banco.demo.features.session.home.infraestructure.dto.response.PostResponseDto
import javax.inject.Inject

class CreatePostMapper
@Inject
constructor(): EntityMapper<CreatePostResponseDto, CreatePostResponse> {

    override fun mapFromEntity(entity: CreatePostResponseDto): CreatePostResponse {
        return CreatePostResponse(
            id = entity.id,
            userId = entity.userId,
            title = entity.title,
            body = entity.body
        )
    }

    override fun mapToEntity(domainModel: CreatePostResponse): CreatePostResponseDto {
        return CreatePostResponseDto(
            id = domainModel.id,
            userId = domainModel.userId,
            title = domainModel.title,
            body = domainModel.body
        )
    }
}