package com.banco.demo.features.session.home.infraestructure.mapper

import com.banco.demo.commons.libs.networking.mapper.EntityMapper
import com.banco.demo.features.session.home.domain.entity.Post
import com.banco.demo.features.session.home.infraestructure.dto.response.PostResponseDto
import javax.inject.Inject

class PostMapper
@Inject
constructor(): EntityMapper<PostResponseDto, Post> {

    override fun mapFromEntity(entity: PostResponseDto): Post {
        return Post(
            id = entity.id,
            userId = entity.userId,
            title = entity.title,
            body = entity.body
        )
    }

    override fun mapToEntity(domainModel: Post): PostResponseDto {
        return PostResponseDto(
            id = domainModel.id,
            userId = domainModel.userId,
            title = domainModel.title,
            body = domainModel.body
        )
    }

    fun mapFromEntityList(entities: List<PostResponseDto>): List<Post>{
        return entities.map { mapFromEntity(it) }
    }
}