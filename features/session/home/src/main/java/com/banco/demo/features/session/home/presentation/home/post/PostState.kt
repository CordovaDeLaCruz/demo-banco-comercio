package com.banco.demo.features.session.home.presentation.home.post

import com.banco.demo.features.session.home.domain.entity.Post

data class PostState(
    val posts: List<Post> = emptyList()
)
