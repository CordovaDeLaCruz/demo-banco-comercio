package com.banco.demo.ui.navigation

sealed class NavigationScreen(val route: String) {

    object SplashNavScreen : NavigationScreen("splash")
    object ClientLoginSecurityNavScreen : NavigationScreen("security_client_login")
    object HomeSessionNavScreen : NavigationScreen("session_appointment")

}