package com.banco.demo.features.splash.presentation.splash

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.banco.demo.ui.R
import com.banco.demo.ui.component.dialog.alert.AlertDialog
import com.banco.demo.ui.navigation.NavigationScreen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel(),
) {

    val alertDialogState = viewModel.alertDialog.value.copy()

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is SplashViewModel.UiEvent.ShowError -> {
                    viewModel.onEvent(
                        SplashEvent.ShowDialog(
                            code = event.code,
                            title = event.title.asString(context),
                            message = event.text.asString(context),
                            textPrimary = if (event.textPrimary != null) {
                                event.textPrimary!!.asString(context)
                            } else {
                                ""
                            },
                            textSecondary = if (event.textSecondary != null) {
                                event.textSecondary!!.asString(context)
                            } else {
                                ""
                            },
                        )
                    )
                }
                is SplashViewModel.UiEvent.SuccessGetParameterByGroup -> {
                    navController.navigate(NavigationScreen.ClientLoginSecurityNavScreen.route) {
                        popUpTo(NavigationScreen.SplashNavScreen.route)
                    }
                }
                is SplashViewModel.UiEvent.SuccessSplash -> {
                    Log.i("LLEGA", "LLEGA")
                    navController.navigate(NavigationScreen.ClientLoginSecurityNavScreen.route) {
                        popUpTo(NavigationScreen.SplashNavScreen.route)
                    }
                }
            }
        }
    }


    AlertDialog(
        isShowDialog = alertDialogState.showDialog,
        title = alertDialogState.title,
        text = alertDialogState.text,
        textPrimary = alertDialogState.textPrimary,
        textSecondary = alertDialogState.textSecondary,
        onClickPrimary = {
            viewModel.onEvent(SplashEvent.DismissDialog)
            viewModel.onEvent(SplashEvent.GetParameters)
        },
        onClickSecondary = {
            viewModel.onEvent(SplashEvent.DismissDialog)
            val activity = (context as? Activity)
            activity?.finish()
        },
        onClickClose = {
            viewModel.onEvent(SplashEvent.DismissDialog)
        }
    )

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_banco_comercio_splash),
            contentDescription = stringResource(id = R.string.content_description_ic_logo),
            contentScale = ContentScale.None
        )
    }


}
