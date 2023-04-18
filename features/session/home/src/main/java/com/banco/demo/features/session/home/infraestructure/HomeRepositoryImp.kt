package com.banco.demo.features.session.home.infraestructure

import com.banco.demo.features.session.home.domain.entity.CreatePostResponse
import com.banco.demo.features.session.home.domain.entity.PersonDate
import com.banco.demo.features.session.home.domain.entity.Post
import com.banco.demo.features.session.home.domain.repository.HomeRepository
import com.banco.demo.features.session.home.infraestructure.dto.response.CreatePostResponseDto
import com.banco.demo.features.session.home.infraestructure.mapper.CreatePostMapper
import com.banco.demo.features.session.home.infraestructure.mapper.PersonMapper
import com.banco.demo.features.session.home.infraestructure.mapper.PostMapper
import javax.inject.Inject

class HomeRepositoryImp @Inject constructor(
    private val apiService: HomeService,
    private val responseGetPersonsMapper: PersonMapper,
    private val responseGetPostMapper: PostMapper,
    private val responseCreatePostMapper: CreatePostMapper,
): HomeRepository {
    override suspend fun getPersons(): List<PersonDate> {
        var response: List<PersonDate>?
        apiService.getPersons().also {
            response = responseGetPersonsMapper.mapFromEntityList(it)
        }
        return response!!
    }

    override suspend fun getPosts(id: String): List<Post> {
        var response: List<Post>?
        apiService.getPost(id).also {
            response = responseGetPostMapper.mapFromEntityList(it)
        }
        return response!!
    }

    override suspend fun createPost(
        title: String,
        body: String,
        userId: Int
    ): CreatePostResponse {
        var response: CreatePostResponse?
        apiService.createPost(
            userId = userId,
            title = title,
            body = body
        ).also {
            response = responseCreatePostMapper.mapFromEntity(
                it
            )
        }
        return response!!
    }
}