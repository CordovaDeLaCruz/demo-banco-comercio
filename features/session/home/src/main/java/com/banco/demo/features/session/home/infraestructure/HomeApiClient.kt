package com.banco.demo.features.session.home.infraestructure

import com.banco.demo.commons.libs.networking.dto.ResponseDto
import com.banco.demo.features.session.home.infraestructure.dto.request.CreatePostRequestDto
import com.banco.demo.features.session.home.infraestructure.dto.response.CreatePostResponseDto
import com.banco.demo.features.session.home.infraestructure.dto.response.PersonDateResponseDto
import com.banco.demo.features.session.home.infraestructure.dto.response.PostResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HomeApiClient {

    @GET("/users")
    suspend fun getPersons(): Response<List<PersonDateResponseDto>>

    @GET("users/{id}/posts")
    suspend fun getPosts(@Path("id") id: String): Response<List<PostResponseDto>>

    @POST("/posts")
    suspend fun createPost(@Body requestBody: CreatePostRequestDto): Response<CreatePostResponseDto>

}