package com.banco.demo.features.splash.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.banco.demo.features.splash.presentation.splash.SplashScreen
import com.banco.demo.ui.navigation.NavigationScreen

fun NavGraphBuilder.splashGraph(navController: NavController) {
    navigation(
        startDestination = com.banco.demo.commons.libs.constants.navigation.SplashNavScreen.InitNavScreen.route,
        route = NavigationScreen.SplashNavScreen.route
    ) {

        composable(
            route = com.banco.demo.commons.libs.constants.navigation.SplashNavScreen.InitNavScreen.route,
        ) {
            SplashScreen(navController)
        }
    }
}