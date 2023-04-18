package com.banco.demo.features.session.home.domain.usecase

import com.banco.demo.features.session.home.domain.entity.CreatePostResponse
import com.banco.demo.features.session.home.domain.repository.HomeRepository

class CreatePostUseCase constructor(private val repository: HomeRepository) {

    suspend operator fun invoke(
        title: String,
        body: String,
        userId: Int
    ): CreatePostResponse {
        return repository.createPost(
            userId = userId,
            title = title,
            body = body
        )
    }

    class InvalidCreatePostException(message: String) : Exception(message)
}