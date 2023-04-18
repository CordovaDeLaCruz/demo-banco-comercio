package com.banco.demo.features.session.home.domain.usecase


data class ClientHomeUseCases(
    val getPersonUseCase: GetPersonsUseCase,
    val getPostsUseCase: GetPostsUseCase,
    val createPostUseCase: CreatePostUseCase
)