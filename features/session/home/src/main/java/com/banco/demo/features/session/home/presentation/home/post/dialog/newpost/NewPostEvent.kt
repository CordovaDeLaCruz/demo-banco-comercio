package com.banco.demo.features.session.home.presentation.home.post.dialog.newpost

import androidx.compose.ui.focus.FocusState

sealed class NewPostEvent{

    data class ShowDialog(
        val code: String,
        val title: String,
        val message: String,
        val textPrimary: String? = "",
        val textSecondary: String? = "",
    ) : NewPostEvent()

    data class EnteredTitle(val value: String) : NewPostEvent()
    data class ChangeTitleFocus(val focusState: FocusState) : NewPostEvent()

    data class EnteredDescription(val value: String) : NewPostEvent()
    data class ChangeDescriptionFocus(val focusState: FocusState) : NewPostEvent()

    object CreatePost : NewPostEvent()
}
