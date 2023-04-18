package com.banco.demo.features.security.client_login.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.banco.demo.commons.libs.constants.navigation.ClientLoginSecurityNavScreen
import com.banco.demo.features.security.client_login.presentation.validate.ValidateLoginScreen
import com.banco.demo.ui.navigation.NavigationScreen

fun NavGraphBuilder.clientLoginSecurityGraph(
    onGoToMain: () -> Unit,
) {

    navigation(
        startDestination = ClientLoginSecurityNavScreen.ValidateNavScreen.route,
        route = NavigationScreen.ClientLoginSecurityNavScreen.route
    ) {

        composable(ClientLoginSecurityNavScreen.ValidateNavScreen.route) {
            ValidateLoginScreen(
                onGoToMain = onGoToMain,
            )
        }
    }
}

