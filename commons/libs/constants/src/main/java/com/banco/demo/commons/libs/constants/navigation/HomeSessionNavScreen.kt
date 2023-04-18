package com.banco.demo.commons.libs.constants.navigation

sealed class HomeSessionNavScreen(val route: String) {

    object HomeNavScreen : HomeSessionNavScreen("session_home")
    object PostsNavScreen : HomeSessionNavScreen("session_posts/{id}")


    fun witArgs(args: Map<String, String>): String {
        var routeFinal = route
        args.forEach {
            routeFinal = routeFinal.replace(it.key, it.value)
        }
        return routeFinal
    }

}