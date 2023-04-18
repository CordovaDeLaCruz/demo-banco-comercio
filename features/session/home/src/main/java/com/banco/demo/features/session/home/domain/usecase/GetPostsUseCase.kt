package com.banco.demo.features.session.home.domain.usecase

import com.banco.demo.features.session.home.domain.entity.PersonDate
import com.banco.demo.features.session.home.domain.entity.Post
import com.banco.demo.features.session.home.domain.repository.HomeRepository

class GetPostsUseCase constructor(private val repository: HomeRepository) {


    suspend operator fun invoke(
        id: String
    ): List<Post> {
        return repository.getPosts(id)
    }

    class InvalidGetPostsException(message: String) : Exception(message)
}