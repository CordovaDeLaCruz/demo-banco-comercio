package com.banco.demo.session

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.banco.demo.features.session.home.presentation.homeSessionGraph
import com.banco.demo.ui.navigation.NavigationScreen


@Composable
fun MainNavigation(
    navController: NavController,
) {

    NavHost(
        navController = navController as NavHostController,
        startDestination = NavigationScreen.HomeSessionNavScreen.route
    ) {
        homeSessionGraph(navController)
    }
}

