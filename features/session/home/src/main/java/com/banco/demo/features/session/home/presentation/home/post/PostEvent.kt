package com.banco.demo.features.session.home.presentation.home.post

sealed class PostEvent{
    data class ShowDialog(
        val code: String,
        val title: String,
        val message: String,
        val textPrimary: String? = "",
        val textSecondary: String? = "",
    ) : PostEvent()

    data class ChangeIsShowDialog(val value: Boolean) : PostEvent()
    object ShowNewDialog: PostEvent()
    object DismissNewDialog : PostEvent()

    data class ChangeIsShowNewDialog(val value: Boolean) : PostEvent()

    //Service
    object FindGetPosts : PostEvent()
}
