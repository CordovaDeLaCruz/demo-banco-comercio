package com.banco.demo.features.security.client_login.presentation.validate

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.banco.demo.commons.libs.social_network.component.FacebookButton
import com.banco.demo.commons.libs.social_network.component.GoogleButton
import com.banco.demo.features.security.client_login.R
import com.banco.demo.ui.component.dialog.LoadingDialog
import com.banco.demo.ui.component.dialog.alert.AlertDialog
import com.banco.demo.ui.component.field.button.LinkButton
import com.banco.demo.ui.component.field.button.PrimaryButton
import com.banco.demo.ui.component.field.inputtext.InputText
import com.banco.demo.ui.theme.*
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ValidateLoginScreen(
    viewModel: ValidateLoginViewModel = hiltViewModel(),
    onGoToMain: () -> Unit,
) {

    val context = LocalContext.current

    val scrollState = rememberScrollState()

    val fieldsInvalidState = viewModel.fieldsInvalid

    val alertDialogState = viewModel.alertDialog.value.copy()

    val passwordState = viewModel.password.value.copy(
        label = stringResource(id = R.string.security_client_login_validate_password_label),
        hint = stringResource(id = R.string.security_client_login_validate_password_hint),
        maxChar = 8,
        keyboardType = KeyboardType.Password
    )

    val emailState = viewModel.email.value.copy(
        hint = stringResource(id = R.string.security_client_login_validate_email_hint)
    )

    var showProgress by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is ValidateLoginViewModel.UiEvent.ShowError -> {
                    viewModel.onEvent(
                        ValidateLoginEvent.ShowDialog(
                            code = event.code,
                            title = event.title.asString(context),
                            message = event.text.asString(context)
                        )
                    )
                }
                is ValidateLoginViewModel.UiEvent.LoadingDialog -> {
                    showProgress = event.isShow
                }

                is ValidateLoginViewModel.UiEvent.SuccessLogin -> {
                    onGoToMain()
                }

            }
        }
    }

    LaunchedEffect(Unit) { scrollState.animateScrollTo(0) }

    LoadingDialog(showDialog = showProgress)
    AlertDialog(
        state = alertDialogState.state,
        isShowDialog = alertDialogState.showDialog,
        title = alertDialogState.title,
        text = alertDialogState.text,
        textPrimary = alertDialogState.textPrimary,
        textSecondary = alertDialogState.textSecondary,
        onClickPrimary = {
            viewModel.onEvent(ValidateLoginEvent.ChangeIsShowDialog(false))
            when (alertDialogState.code) {

            }
        },
        onClickClose = {
            viewModel.onEvent(ValidateLoginEvent.ChangeIsShowDialog(false))
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        LoadingDialog(showDialog = showProgress)
        Spacer(modifier = Modifier.height(45.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = stringResource(id = R.string.security_client_login_validate_welcome),
            fontFamily = Gotham,
            fontWeight = FontWeight.Normal,
            lineHeight = 12.sp,
            fontSize = 16.sp,
            color = NeutralDarkGreyBlack
        )

        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = stringResource(id = R.string.security_client_login_validate_sign_in),
            fontFamily = Gotham,
            fontWeight = FontWeight.Normal,
            lineHeight = 35.sp,
            fontSize = 30.sp,
            color = NeutralDarkGreyBlack
        )

        Spacer(modifier = Modifier.height(28.dp))

        InputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            label = stringResource(id = R.string.security_client_login_validate_email_label),
            hint = emailState.hint,
            value = emailState.text,
            error = emailState.error,
            maxChar = emailState.maxChar,
            keyboardType = KeyboardType.Email,
            state = emailState.state,
            isHintVisible = emailState.isHintVisible,
            onValueChange = {
                viewModel.onEvent(ValidateLoginEvent.EnteredEmailNumber(it))
            },
            onFocusChange = {
                viewModel.onEvent(ValidateLoginEvent.ChangeEmailFocus(it))
            },
        )

        Spacer(modifier = Modifier.height(28.dp))

        InputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            label = passwordState.label,
            hint = passwordState.hint,
            value = passwordState.text,
            error = passwordState.error,
            state = passwordState.state,
            maxChar = passwordState.maxChar,
            isHintVisible = passwordState.isHintVisible,
            keyboardType = KeyboardType.Password,
            onValueChange = {
                viewModel.onEvent(ValidateLoginEvent.EnteredPassword(it))
            },
            onFocusChange = {
                viewModel.onEvent(ValidateLoginEvent.ChangePasswordFocus(it))
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(28.dp))

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            PrimaryButton(
                text = stringResource(id = com.banco.demo.ui.R.string.button_continue),
                modifier = Modifier,
                enabled = fieldsInvalidState.size == 0,
                onClick = {
                    viewModel.onEvent(ValidateLoginEvent.Login)
                }
            )
            Spacer(modifier = Modifier.height(20.dp))

            LinkButton(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                text = stringResource(id = R.string.security_client_login_validate_reset_password),
                onClick = {
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                text = stringResource(id = R.string.security_client_login_validate_social_media),
                fontFamily = Gotham,
                fontWeight = FontWeight.Normal,
                lineHeight = 12.sp,
                fontSize = 10.sp,
                color = NeutralDarkGreyBlack
            )
        }


        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            GoogleButton(
                modifier = Modifier
            )
            FacebookButton(
                modifier = Modifier,
            )
        }


        Spacer(modifier = Modifier.height(20.dp))

    }


}

