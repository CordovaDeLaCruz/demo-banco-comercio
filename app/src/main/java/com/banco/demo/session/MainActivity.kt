/* Banco Demo 2023 */
package com.banco.demo.session

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.banco.demo.AuthActivity
import com.banco.demo.commons.libs.constants.navigation.HomeSessionNavScreen
import com.banco.demo.presentation.BaseAppActivity
import com.banco.demo.ui.R
import com.banco.demo.ui.component.toolbar.AppToolbar
import com.banco.demo.ui.component.toolbar.AppToolbarState
import com.banco.demo.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseAppActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val context = LocalContext.current

            var visibleBottomBar by remember {
                mutableStateOf(true)
            }

            var visibilityProfile by remember {
                mutableStateOf(false)
            }

            var stateToolbar by remember {
                mutableStateOf(AppToolbarState.Main.state)
            }

            var titleToolbar by remember {
                mutableStateOf("")
            }


            navController.addOnDestinationChangedListener { _, _, _ ->
                when (navController.currentDestination?.route) {
                    HomeSessionNavScreen.HomeNavScreen.route -> {
                        visibleBottomBar = true
                        visibilityProfile = false
                        titleToolbar = ""
                        stateToolbar = AppToolbarState.Main.state
                    }

                    HomeSessionNavScreen.PostsNavScreen.route -> {
                        visibleBottomBar = false
                        visibilityProfile = false
                        titleToolbar = context.getString(R.string.list_posts)
                        stateToolbar = AppToolbarState.CloseLight.state
                    }
                }
            }

            BancoDemoAppTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(

                    ) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            AppToolbar(
                                state = stateToolbar,
                                title = titleToolbar,
                                visibilityProfile = visibilityProfile,
                                onBack = {
                                    navController.popBackStack()
                                },
                                onClose = {
                                    when (navController.currentDestination?.route) {
                                        else -> {
                                            navController.popBackStack()
                                        }
                                    }
                                },
                                onExit = {
                                    when (navController.currentDestination?.route) {
                                        else -> {
                                            navController.popBackStack()
                                        }
                                    }
                                },
                                onProfile = {
                                    visibilityProfile = !visibilityProfile

                                },
                                onNotification = {
//                                    navController.popBackStack()
                                },
                                onMenu = {
//                                    navController.popBackStack()
                                }
                            )
                            Box(modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.TopStart) {

                                MainNavigation(navController)

                                Column() {
                                    AnimatedVisibility(
                                        visible = visibilityProfile,
                                        enter = fadeIn() + slideInVertically(),
                                        exit = fadeOut() + slideOutVertically(),
                                    ) {
                                        Row(modifier = Modifier
                                            .height(48.dp)
                                            .fillMaxWidth()
                                            .background(PrimaryPurpleLightestWhite),
                                            horizontalArrangement = Arrangement.SpaceEvenly,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            TextButton(
                                                onClick = {
                                                    visibilityProfile = false
                                                    startActivity(Intent(context,
                                                        AuthActivity::class.java))
                                                    finish()
                                                }
                                            ) {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.ic_sing_out),
                                                    contentDescription = "",
                                                    modifier = Modifier,
                                                    tint = NeutralDarkGreyBlack
                                                )
                                                Text(
                                                    text = stringResource(id = R.string.sign_out),
                                                    style = MaterialTheme.typography.caption,
                                                    color = NeutralDarkGreyBlack)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
