package com.banco.demo.features.session.home.infraestructure

import com.banco.demo.features.session.home.infraestructure.dto.request.CreatePostRequestDto
import com.banco.demo.features.session.home.infraestructure.dto.response.CreatePostResponseDto
import com.banco.demo.features.session.home.infraestructure.dto.response.PersonDateResponseDto
import com.banco.demo.features.session.home.infraestructure.dto.response.PostResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class HomeService @Inject constructor(private val retrofit: Retrofit){

    suspend fun getPersons(
    ): List<PersonDateResponseDto> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(HomeApiClient::class.java)
                .getPersons()
            response.body()!!
        }
    }

    suspend fun getPost(id: String
    ): List<PostResponseDto> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(HomeApiClient::class.java)
                .getPosts(id)
            response.body()!!
        }
    }

    suspend fun createPost(
        title: String, body: String, userId: Int
    ): CreatePostResponseDto {
        return withContext(Dispatchers.IO) {
            val createPostRequestDto = CreatePostRequestDto(
                userId = userId,
                body = body,
                title = title
            )
            val response = retrofit.create(HomeApiClient::class.java)
                .createPost(createPostRequestDto)
            response.body()!!
        }
    }

}