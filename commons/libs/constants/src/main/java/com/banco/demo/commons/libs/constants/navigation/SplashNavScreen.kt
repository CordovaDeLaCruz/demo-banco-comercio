package com.banco.demo.commons.libs.constants.navigation

sealed class SplashNavScreen(val route: String) {

    object InitNavScreen : SplashNavScreen("splash_init_screen")

    fun witArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}