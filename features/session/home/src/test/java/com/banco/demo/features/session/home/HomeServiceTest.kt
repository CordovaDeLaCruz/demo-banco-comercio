package com.banco.demo.features.session.home

import com.banco.demo.features.session.home.infraestructure.HomeApiClient
import com.banco.demo.features.session.home.infraestructure.HomeService
import com.banco.demo.features.session.home.infraestructure.dto.request.CreatePostRequestDto
import com.banco.demo.features.session.home.infraestructure.dto.response.CreatePostResponseDto
import com.banco.demo.features.session.home.infraestructure.dto.response.PersonDateResponseDto
import com.banco.demo.features.session.home.infraestructure.dto.response.PostResponseDto
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.test.runTest
import org.junit.Test
import retrofit2.Response
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class HomeServiceTest {


    @Test
    fun `Given a successful response for getPersons, When getPersons is called, Then return the list of persons`() = runTest{
        val response = Response.success(listOf(PersonDateResponseDto("john@gmail.com", 1, "John Doe", "999999123", "john", "asd"), PersonDateResponseDto("john@gmail.com", 1, "John Doe", "999999123", "john", "asd")))
        val apiClient = mock<HomeApiClient>() {
            onBlocking {
                getPersons()
            } doReturn response
        }

        val homeService = HomeService(apiClient)

        val result = homeService.getPersons()

        expectThat(result).isEqualTo(response.body())
    }

    @Test
    fun `Given a successful response for getPosts, When getPosts is called with a valid id, Then return the list of posts`() = runTest{
        val response = Response.success(listOf(PostResponseDto("1", 1, "Body 1", 1), PostResponseDto("body2", 2, "Body 2", 1)))
        val apiClient = mock<HomeApiClient>() {
            onBlocking {
                getPosts("1")
            } doReturn response
        }

        val homeService = HomeService(apiClient)

        val result = homeService.getPost("1")

        expectThat(result).isEqualTo(response.body())
    }

    @Test
    fun `Given a successful response for createPost, When createPost is called with valid parameters, Then return the created post`() = runTest {
        val createPostRequestDto = CreatePostRequestDto(userId = 1, title = "New Post", body = "New Body")
        val response = Response.success(CreatePostResponseDto(id = 1, userId = 1, title = "New Post", body = "New Body"))

        val apiClient = mock<HomeApiClient>() {
            onBlocking {
                createPost(createPostRequestDto)
            } doReturn response
        }

        val homeService = HomeService(apiClient)

        val result = homeService.createPost("New Post", "New Body", 1)

        expectThat(result).isEqualTo(response.body())
    }
}
