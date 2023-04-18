/* Banco Demo 2023 */
package com.banco.demo.features.security.client_login.presentation.validate

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banco.demo.commons.domain.validator.UtilValidator
import com.banco.demo.commons.libs.networking.NetworkException
import com.banco.demo.features.security.client_login.R
import com.banco.demo.ui.component.dialog.alert.AlertDialogState
import com.banco.demo.ui.component.field.inputtext.InputTextState
import com.banco.demo.ui.component.field.inputtext.InputTextViewState
import com.banco.demo.ui.resource.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ValidateLoginViewModel @Inject constructor(
) : ViewModel() {

    private val _fieldsInvalid: MutableList<Invalid> = mutableListOf(
        Invalid.Email,
        Invalid.Password
    )

    val fieldsInvalid: MutableList<Invalid> = _fieldsInvalid

    private val _alertDialog = mutableStateOf(
        AlertDialogState(
            showDialog = false
        )
    )
    val alertDialog: State<AlertDialogState> = _alertDialog

    private val _email = mutableStateOf(
        InputTextState()
    )
    val email: State<InputTextState> = _email

    private val _password = mutableStateOf(
        InputTextState()
    )
    val password: State<InputTextState> = _password

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: ValidateLoginEvent) {
        when (event) {
            is ValidateLoginEvent.ShowDialog -> {
                _alertDialog.value = alertDialog.value.copy(
                    code = event.code,
                    title = event.title,
                    showDialog = true,
                    text = event.message,
                    textPrimary = event.textPrimary,
                    textSecondary = event.textSecondary
                )
            }

            is ValidateLoginEvent.DismissDialog -> {
                _alertDialog.value = alertDialog.value.copy(
                    showDialog = false
                )
            }

            is ValidateLoginEvent.ChangeIsShowDialog -> {
                _alertDialog.value = alertDialog.value.copy(
                    showDialog = event.value,
                )

            }

            is ValidateLoginEvent.EnteredEmailNumber -> {
                val state = InputTextState.validateState(
                    isError = !isValidEmail(
                        email = event.value
                    ),
                    isFocused = email.value.isFocused,
                )
                if (state == InputTextViewState.Error.state) {
                    if (fieldsInvalid.indexOf(Invalid.Email) == -1) {
                        fieldsInvalid.add(Invalid.Email)
                    }
                } else {
                    if (fieldsInvalid.indexOf(Invalid.Email) != -1) {
                        fieldsInvalid.remove(Invalid.Email)
                    }
                }
                _email.value = email.value.copy(
                    text = event.value,
                    state = state,
                    error = if (state == InputTextViewState.Error.state) R.string.security_client_login_validate_email_error else -1
                )
            }
            is ValidateLoginEvent.ChangeEmailFocus -> {
                _email.value = email.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            email.value.text.isBlank(),
                )
            }

            is ValidateLoginEvent.EnteredPassword -> {
                val state = InputTextState.validateState(
                    isError = !isValidPassword(
                        password = event.value
                    ),
                    isFocused = password.value.isFocused,
                )
                changeInputTextFieldsInvalid(state, Invalid.Password)
                _password.value = password.value.copy(
                    text = event.value,
                    state = state,
                    error = if (state == InputTextViewState.Error.state) R.string.security_client_login_validate_password_error else -1
                )
            }
            is ValidateLoginEvent.ChangePasswordFocus -> {
                _password.value = password.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            password.value.text.isBlank(),
                )
            }
            is ValidateLoginEvent.Login -> {
                viewModelScope.launch {
                    _eventFlow.emit(UiEvent.LoadingDialog(true))
                    try {
                        _eventFlow.emit(UiEvent.LoadingDialog(false))
                        _eventFlow.emit(UiEvent.SuccessLogin)
                    } catch (e: NetworkException) {
                        _eventFlow.emit(UiEvent.LoadingDialog(false))
                        _eventFlow.emit(
                            UiEvent.ShowError(
                                code = e.code,
                                title = UiText.StringResource(com.banco.demo.ui.R.string.alert_dialog_title_default),
                                text = if (e.message.isNullOrEmpty()) {
                                    UiText.StringResource(com.banco.demo.ui.R.string.network_exception)
                                } else {
                                    UiText.DynamicString(e.message!!)
                                },
                                textPrimary = UiText.DynamicString(""),
                                textSecondary = UiText.DynamicString("")
                            )
                        )
                    }
                }
            }
        }
    }

    private fun changeInputTextFieldsInvalid(state: String, fieldInvalid: Invalid) {
        if (state == InputTextViewState.Error.state) {
            if (fieldsInvalid.indexOf(fieldInvalid) == -1) {
                fieldsInvalid.add(fieldInvalid)
            }
        } else {
            if (fieldsInvalid.indexOf(fieldInvalid) != -1) {
                fieldsInvalid.remove(fieldInvalid)
            }
        }
    }

    sealed class UiEvent {
        data class ShowError(
            var code: String,
            var title: UiText,
            var text: UiText,
            var textPrimary: UiText?,
            var textSecondary: UiText?,
        ) : UiEvent()

        data class LoadingDialog(val isShow: Boolean) : UiEvent()

       object SuccessLogin : UiEvent()

    }

    private fun isValidPassword(password: String): Boolean {
        return UtilValidator.isValidPassword(password = password)
    }

    private fun isValidEmail(email: String): Boolean {
        return UtilValidator.isValidEmail(email = email)
    }

    sealed class Invalid {
        object Email : Invalid()
        object Password : Invalid()
    }
}
