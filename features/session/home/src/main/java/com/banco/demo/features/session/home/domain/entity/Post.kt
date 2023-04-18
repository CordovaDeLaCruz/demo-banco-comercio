package com.banco.demo.features.session.home.domain.entity

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)