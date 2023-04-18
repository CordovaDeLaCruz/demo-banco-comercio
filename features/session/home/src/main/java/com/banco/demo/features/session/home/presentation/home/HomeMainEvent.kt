package com.banco.demo.features.session.home.presentation.home

sealed class HomeMainEvent{
    data class ShowDialog(
        val code: String,
        val title: String,
        val message: String,
        val textPrimary: String? = "",
        val textSecondary: String? = "",
    ) : HomeMainEvent()

    data class ChangeIsShowDialog(val value: Boolean) : HomeMainEvent()

    //Service
    object FindGetPersonData : HomeMainEvent()
}
