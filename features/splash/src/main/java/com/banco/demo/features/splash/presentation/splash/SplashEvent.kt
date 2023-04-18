package com.banco.demo.features.splash.presentation.splash

sealed class SplashEvent {
    data class ShowDialog(
        val code: String,
        val title: String,
        val message: String,
        val textPrimary: String? = "",
        val textSecondary: String? = "",
    ) : SplashEvent()

    object DismissDialog : SplashEvent()

    object GetParameters : SplashEvent()

    object GoToLogin : SplashEvent()
}

