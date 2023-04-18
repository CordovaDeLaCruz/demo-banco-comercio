package com.banco.demo.features.session.home.presentation.home

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banco.demo.commons.libs.networking.NetworkException
import com.banco.demo.features.session.home.domain.usecase.ClientHomeUseCases
import com.banco.demo.ui.component.dialog.alert.AlertDialogState
import com.banco.demo.ui.resource.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.banco.demo.ui.R as UiR
@HiltViewModel
class HomeMainViewModel @Inject constructor(
    @ApplicationContext appContext: Context,
    private val homeUseCases: ClientHomeUseCases,
) : ViewModel() {

    private val _showProgress = mutableStateOf(false)
    val showProgress: State<Boolean> = _showProgress

    private val _alertDialog = mutableStateOf(
        AlertDialogState(
            showDialog = false
        )
    )
    val alertDialog: State<AlertDialogState> = _alertDialog

    private val _persons = mutableStateOf(PersonState())
    val persons: State<PersonState> = _persons

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        onEvent(HomeMainEvent.FindGetPersonData)
    }

    fun onEvent(event: HomeMainEvent) {
        when (event) {
            is HomeMainEvent.ShowDialog -> {
                _alertDialog.value = _alertDialog.value.copy(
                    code = event.code,
                    title = event.title,
                    showDialog = true,
                    text = event.message,
                    textPrimary = event.textPrimary,
                    textSecondary = event.textSecondary
                )
            }
            is HomeMainEvent.ChangeIsShowDialog -> {
                _alertDialog.value = alertDialog.value.copy(
                    showDialog = event.value,
                )

            }
            is HomeMainEvent.FindGetPersonData -> {
                viewModelScope.launch {
                    _eventFlow.emit(UiEvent.LoadingDialog(true))
                    try {
                        homeUseCases.getPersonUseCase().also { it ->
                            _persons.value = persons.value.copy(persons = it)
                        }
                        _eventFlow.emit(UiEvent.LoadingDialog(false))
                    } catch (e: NetworkException) {
                        _eventFlow.emit(UiEvent.LoadingDialog(false))
                        _eventFlow.emit(
                            UiEvent.ShowError(
                                code = e.code,
                                title = UiText.StringResource(UiR.string.alert_dialog_title_default),
                                text = if (e.message.isNullOrEmpty()) {
                                    UiText.StringResource(UiR.string.network_exception)
                                } else {
                                    UiText.DynamicString(e.message!!)
                                },
                                textPrimary = UiText.StringResource(UiR.string.retry),
                                textSecondary = UiText.StringResource(UiR.string.exit)
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

        data class LoadingDialog(val isShow: Boolean) : UiEvent()
    }
}