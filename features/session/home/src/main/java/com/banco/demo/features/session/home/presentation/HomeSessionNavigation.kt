package com.banco.demo.features.session.home.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.banco.demo.commons.libs.constants.navigation.HomeSessionNavScreen
import com.banco.demo.features.session.home.presentation.home.HomeScreen
import com.banco.demo.features.session.home.presentation.home.post.PostsScreen
import com.banco.demo.ui.navigation.NavigationScreen

fun NavGraphBuilder.homeSessionGraph(navController: NavController) {

    navigation(
        startDestination = HomeSessionNavScreen.HomeNavScreen.route,
        route = NavigationScreen.HomeSessionNavScreen.route
    ) {

        composable(HomeSessionNavScreen.HomeNavScreen.route) {
            HomeScreen(navController)
        }

        composable(
            HomeSessionNavScreen.PostsNavScreen.route,
            arguments = listOf(
                navArgument("id") { type = NavType.StringType },
            )
        ) { backStackEntry ->
            PostsScreen(navController = navController, id = backStackEntry.arguments?.getString("id")!!)
        }

    }
}