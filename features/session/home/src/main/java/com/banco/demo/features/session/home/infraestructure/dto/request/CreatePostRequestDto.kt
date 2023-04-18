package com.banco.demo.features.session.home.infraestructure.dto.request

data class CreatePostRequestDto(
    val body: String,
    val title: String,
    val userId: Int
)