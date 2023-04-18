package com.banco.demo.features.session.home.presentation.home.post

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banco.demo.commons.libs.networking.NetworkException
import com.banco.demo.features.session.home.domain.usecase.ClientHomeUseCases
import com.banco.demo.features.session.home.presentation.home.post.dialog.NewDialogState
import com.banco.demo.ui.component.dialog.alert.AlertDialogState
import com.banco.demo.ui.resource.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.banco.demo.ui.R as UiR
@HiltViewModel
class PostViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val homeUseCases: ClientHomeUseCases,
) : ViewModel() {

    private val _alertDialog = mutableStateOf(
        AlertDialogState(
            showDialog = false
        )
    )
    val alertDialog: State<AlertDialogState> = _alertDialog

    private val _posts = mutableStateOf(PostState())
    val posts: State<PostState> = _posts

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _routeId = mutableStateOf("")

    private val routeId: State<String> = _routeId

    private val _alertNewDialog = mutableStateOf(
        NewDialogState(
            showNewDialog = false
        )
    )
    val alertNewDialog: State<NewDialogState> = _alertNewDialog

    fun initId(id: String) {
        _routeId.value = id
    }

    init {
        savedStateHandle.get<String>("id")?.let { id ->
            _routeId.value = id
        }
        onEvent(PostEvent.FindGetPosts)
    }

    fun onEvent(event: PostEvent) {
        when (event) {
            is PostEvent.ShowDialog -> {
                _alertDialog.value = _alertDialog.value.copy(
                    code = event.code,
                    title = event.title,
                    showDialog = true,
                    text = event.message,
                    textPrimary = event.textPrimary,
                    textSecondary = event.textSecondary
                )
            }
            is PostEvent.ChangeIsShowDialog -> {
                _alertDialog.value = alertDialog.value.copy(
                    showDialog = event.value,
                )

            }
            is PostEvent.ShowNewDialog -> {
                _alertNewDialog.value = _alertNewDialog.value.copy(
                    showNewDialog = true,
                )
            }
            is PostEvent.DismissNewDialog -> {
                _alertNewDialog.value = _alertNewDialog.value.copy(
                    showNewDialog = false
                )
            }
            is PostEvent.ChangeIsShowNewDialog -> {
                _alertNewDialog.value = _alertNewDialog.value.copy(
                    showNewDialog = event.value,
                )

            }
            is PostEvent.FindGetPosts -> {
                viewModelScope.launch {
                    _eventFlow.emit(UiEvent.LoadingDialog(true))
                    try {
                        homeUseCases.getPostsUseCase(routeId.value).also { it ->
                            _posts.value = posts.value.copy(posts = it)
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