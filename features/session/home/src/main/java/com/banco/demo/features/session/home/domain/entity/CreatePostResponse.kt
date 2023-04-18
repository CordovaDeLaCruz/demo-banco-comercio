package com.banco.demo.features.session.home.domain.entity

data class CreatePostResponse(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)