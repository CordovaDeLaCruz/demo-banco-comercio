package com.banco.demo

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.banco.demo.features.security.client_login.presentation.clientLoginSecurityGraph
import com.banco.demo.features.splash.presentation.splashGraph
import com.banco.demo.ui.navigation.NavigationScreen


@Composable
fun AuthNavigation(
    navController: NavController,
    onGoToMain: () -> Unit,
) {

    NavHost(
        navController = navController as NavHostController,
        startDestination = NavigationScreen.ClientLoginSecurityNavScreen.route
    ) {
        splashGraph(navController)
        clientLoginSecurityGraph(onGoToMain)
    }
}

