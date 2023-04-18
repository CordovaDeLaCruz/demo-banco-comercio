package com.banco.demo.commons.libs.constants.navigation

sealed class ClientLoginSecurityNavScreen(val route: String) {

    object ValidateNavScreen : ClientLoginSecurityNavScreen("security_client_login_validate_screen")


    fun witArgs(args: Map<String, String>): String {
        var routeFinal = route
        args.forEach {
            routeFinal = routeFinal.replace(it.key, it.value)
        }
        return routeFinal
    }

}