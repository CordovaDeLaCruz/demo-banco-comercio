package com.banco.demo.features.session.home.presentation.home.post.dialog.newpost

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banco.demo.commons.domain.validator.UtilValidator
import com.banco.demo.commons.libs.networking.NetworkException
import com.banco.demo.features.session.home.domain.usecase.ClientHomeUseCases
import com.banco.demo.features.session.home.presentation.home.post.PostEvent
import com.banco.demo.ui.component.field.inputtext.InputTextState
import com.banco.demo.ui.component.field.inputtext.InputTextViewState
import com.banco.demo.ui.resource.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.banco.demo.ui.R as UiR


@HiltViewModel
class NewPostViewModel @Inject constructor(
    private val homeUseCases: ClientHomeUseCases,

    ) : ViewModel() {

    private val _fieldsInvalid: MutableList<Invalid> = mutableListOf(
        Invalid.Title,
        Invalid.Description
    )
    val fieldsInvalid: MutableList<Invalid> = _fieldsInvalid


    private var _idUser: String? = null

    private val _title = mutableStateOf(InputTextState(text = ""))
    val title: State<InputTextState> = _title

    private val _description = mutableStateOf(InputTextState(text = ""))
    val description: State<InputTextState> = _description

    fun initIdUser(idUser: String) {
        _idUser = idUser
    }

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: NewPostEvent) {
        when (event) {
            is NewPostEvent.EnteredTitle -> {
                val state = InputTextState.validateState(
                    isError = !isValidText(event.value),
                    isFocused = title.value.isFocused,
                )
                if (state == InputTextViewState.Error.state) {
                    if (fieldsInvalid.indexOf(Invalid.Title) == -1) {
                        fieldsInvalid.add(Invalid.Title)
                    }
                } else {
                    if (fieldsInvalid.indexOf(Invalid.Title) != -1) {
                        fieldsInvalid.remove(Invalid.Title)
                    }
                }
                _title.value = title.value.copy(
                    text = event.value,
                    state = state,
                    error = if (state == InputTextViewState.Error.state) UiR.string.modal_new_post_title_error else -1
                )
            }
            is NewPostEvent.ChangeTitleFocus -> {
                _title.value = title.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            title.value.text.isBlank(),
                )
            }
            is NewPostEvent.EnteredDescription -> {
                val state = InputTextState.validateState(
                    isError = !isValidText(event.value),
                    isFocused = description.value.isFocused,
                )
                if (state == InputTextViewState.Error.state) {
                    if (fieldsInvalid.indexOf(Invalid.Description) == -1) {
                        fieldsInvalid.add(Invalid.Description)
                    }
                } else {
                    if (fieldsInvalid.indexOf(Invalid.Description) != -1) {
                        fieldsInvalid.remove(Invalid.Description)
                    }
                }
                _description.value = description.value.copy(
                    text = event.value,
                    state = state,
                    error = if (state == InputTextViewState.Error.state) UiR.string.modal_new_post_description_error else -1
                )
            }
            is NewPostEvent.ChangeDescriptionFocus -> {
                _description.value = description.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            title.value.text.isBlank(),
                )
            }
            is NewPostEvent.CreatePost -> {
                viewModelScope.launch {
                    _eventFlow.emit(UiEvent.LoadingDialog(true))
                    try {
                        homeUseCases.createPostUseCase(
                            title = _title.value.text,
                            body = _description.value.text,
                            userId = _idUser!!.toInt()
                        ).also {
                            _eventFlow.emit(UiEvent.LoadingDialog(false))
                            _title.value.text = ""
                            _description.value.text = ""
                            _eventFlow.emit(UiEvent.SuccessCreation)
                        }
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

    sealed class Invalid {
        object Title : Invalid()
        object Description : Invalid()
    }

    private fun isValidText(
        value: String,
    ): Boolean {
        var isValid = true
        if (!UtilValidator.isTextNotNullAndNotEmptyAndNotBlank(value)) {
            isValid = false
        }
        return isValid
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

        object SuccessCreation : UiEvent()

    }


}