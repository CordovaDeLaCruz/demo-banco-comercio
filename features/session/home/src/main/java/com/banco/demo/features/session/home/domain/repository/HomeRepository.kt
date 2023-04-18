package com.banco.demo.features.session.home.domain.repository

import com.banco.demo.features.session.home.domain.entity.CreatePostResponse
import com.banco.demo.features.session.home.domain.entity.PersonDate
import com.banco.demo.features.session.home.domain.entity.Post
import com.banco.demo.features.session.home.infraestructure.dto.response.CreatePostResponseDto

interface HomeRepository {

    suspend fun getPersons(): List<PersonDate>

    suspend fun getPosts(id: String): List<Post>

    suspend fun createPost(
        title: String,
        body: String,
        userId: Int
    ): CreatePostResponse

}