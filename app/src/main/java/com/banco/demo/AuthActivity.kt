/* Banco Demo 2023 */
package com.banco.demo

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.banco.demo.presentation.BaseAppActivity
import com.banco.demo.session.MainActivity
import com.banco.demo.ui.component.toolbar.AppToolbar
import com.banco.demo.ui.component.toolbar.AppToolbarState
import com.banco.demo.ui.navigation.NavigationScreen
import com.banco.demo.ui.theme.BancoDemoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseAppActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current

            BancoDemoAppTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    val stepCount by remember {
                        mutableStateOf(4)
                    }
                    var stepPositionSelected by remember {
                        mutableStateOf(1)
                    }

                    var visibilityStep by remember {
                        mutableStateOf(false)
                    }


                    var visibleToolbar by remember {
                        mutableStateOf(false)
                    }

                    var appToolbarState by remember {
                        mutableStateOf(AppToolbarState.OnlyLogo.state)
                    }

                    var visibilityTabs by remember {
                        mutableStateOf(false)
                    }

                    var tabNum by remember { mutableStateOf(0) }

                    navController.addOnDestinationChangedListener { _, _, _ ->

                        when (navController.currentDestination?.route) {
                            com.banco.demo.commons.libs.constants.navigation.SplashNavScreen.InitNavScreen.route -> {
                                visibleToolbar = false
                                appToolbarState = AppToolbarState.OnlyLogo.state
                                visibilityTabs = false

                                visibilityStep = false
                                stepPositionSelected = 1

                                tabNum = 0
                            }
                        }
                    }

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start

                    ) {
                        AnimatedVisibility(
                            visible = visibleToolbar,
                            enter = fadeIn() + slideInVertically(),
                            exit = fadeOut() + slideOutVertically()
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.Start
                            ) {

                                AppToolbar(
                                    state = appToolbarState,
                                    title = "",
                                    onBack = {
                                        navController.popBackStack()
                                    },
                                    onClose = {
                                        navController.popBackStack()
                                    },
                                    onExit = {
                                        navController.popBackStack()
                                    },
                                    onProfile = {
                                        navController.popBackStack()
                                    },
                                    onNotification = {
                                        navController.popBackStack()
                                    },
                                    onMenu = {
                                        navController.popBackStack()
                                    }
                                )
                            }

                        }
                        AnimatedVisibility(
                            visible = visibilityStep,
                            enter = fadeIn() + slideInVertically(),
                            exit = fadeOut() + slideOutVertically()
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Spacer(modifier = Modifier.height(16.dp))
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                        }

                        AnimatedVisibility(
                            visible = visibilityTabs,
                            enter = fadeIn() + slideInVertically(),
                            exit = fadeOut() + slideOutVertically()
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.Start
                            ) {
                                navController.navigate(NavigationScreen.ClientLoginSecurityNavScreen.route) {
                                    popUpTo(NavigationScreen.ClientLoginSecurityNavScreen.route) {
                                        inclusive = true
                                    }
                                }
                            }
                        }
                        AuthNavigation(
                            navController = navController,
                            onGoToMain = {
                                startActivity(Intent(context, MainActivity::class.java))
                                finish()
                            }
                        )
                    }
                }
            }
        }
    }
}
