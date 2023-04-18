/* Banco Demo 2023 */
package com.banco.demo.features.splash.presentation.splash

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banco.demo.commons.domain.entity.Parameter
import com.banco.demo.commons.features.domain.usecase.parameter.GetParametersByGroupUseCase
import com.banco.demo.commons.libs.constants.Strings
import com.banco.demo.commons.libs.networking.NetworkException
import com.banco.demo.features.splash.domain.usecase.SplashUseCases
import com.banco.demo.ui.R
import com.banco.demo.ui.component.dialog.alert.AlertDialogState
import com.banco.demo.ui.resource.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val splashUseCases: SplashUseCases,
) : ViewModel() {

    private val _alertDialog = mutableStateOf(
        AlertDialogState(
            showDialog = false
        )
    )
    val alertDialog: State<AlertDialogState> = _alertDialog


    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        onEvent(SplashEvent.GetParameters)
        //onEvent(SplashEvent.GoToLogin)
    }

    fun onEvent(event: SplashEvent) {
        when (event) {
            is SplashEvent.ShowDialog -> {
                _alertDialog.value = _alertDialog.value.copy(
                    title = event.title,
                    showDialog = true,
                    text = event.message,
                    textPrimary = event.textPrimary,
                    textSecondary = event.textSecondary
                )
            }
            is SplashEvent.DismissDialog -> {
                _alertDialog.value = _alertDialog.value.copy(
                    showDialog = false
                )
            }
            is SplashEvent.GetParameters -> {
                viewModelScope.launch {
                    try {
                        splashUseCases.getParametersByGroup(
                            group = GetParametersByGroupUseCase.GROUP_DOCUMENT,
                            isRefresh = true)
                            .also { it ->
                                when (it.responseCode) {
                                    Strings.SERVICE_CODE_SUCCESS -> {
                                        _eventFlow.emit(UiEvent.SuccessGetParameterByGroup(it.body!!))
                                    }
                                    else -> {
                                        _eventFlow.emit(
                                            UiEvent.ShowError(
                                                code = "00000",
                                                title = UiText.StringResource(R.string.alert_dialog_title_default),
                                                text = if (it.responseMessage.isEmpty()) {
                                                    UiText.StringResource(R.string.network_exception)
                                                } else {
                                                    UiText.DynamicString(it.responseMessage)
                                                },
                                                textPrimary = UiText.DynamicString(""),
                                                textSecondary = UiText.DynamicString("")
                                            )
                                        )
                                    }
                                }
                            }
                    } catch (e: NetworkException) {
                        _eventFlow.emit(
                            UiEvent.ShowError(
                                code = e.code,
                                title = UiText.StringResource(R.string.alert_dialog_title_default),
                                text = if (e.message.isNullOrEmpty()) {
                                    UiText.StringResource(R.string.network_exception)
                                } else {
                                    UiText.DynamicString(e.message!!)
                                },
                                textPrimary = UiText.StringResource(R.string.retry),
                                textSecondary = UiText.StringResource(R.string.exit)
                            )
                        )
                    }
                }
            }

            is SplashEvent.GoToLogin -> {
                viewModelScope.launch{
                    try {
                        _eventFlow.emit(UiEvent.SuccessSplash)
                    }catch (e: NetworkException) {
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

    sealed class UiEvent {
        data class ShowError(
            var code: String,
            var title: UiText,
            var text: UiText,
            var textPrimary: UiText?,
            var textSecondary: UiText?,
        ) : UiEvent()

        data class SuccessGetParameterByGroup(var parameters: List<Parameter>) : UiEvent()

        object SuccessSplash: UiEvent()
    }
}
