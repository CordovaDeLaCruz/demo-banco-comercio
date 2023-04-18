package com.banco.demo.features.security.client_login.presentation.validate

import androidx.compose.ui.focus.FocusState
import com.banco.demo.commons.domain.entity.Parameter

sealed class ValidateLoginEvent {
    data class ShowDialog(
        val code: String,
        val title: String,
        val message: String,
        val textPrimary: String? = "",
        val textSecondary: String? = "",
    ) : ValidateLoginEvent()

    object DismissDialog : ValidateLoginEvent()
    data class ChangeIsShowDialog(val value: Boolean) : ValidateLoginEvent()

    data class SelectedDocumentType(val value: Parameter) : ValidateLoginEvent()
    data class EnteredDocumentNumber(val value: String) : ValidateLoginEvent()
    data class ChangeDocumentNumberFocus(val focusState: FocusState) : ValidateLoginEvent()

    data class EnteredEmailNumber(val value: String) : ValidateLoginEvent()
    data class ChangeEmailFocus(val focusState: FocusState) : ValidateLoginEvent()
    data class EnteredPassword(val value: String) : ValidateLoginEvent()
    data class ChangePasswordFocus(val focusState: FocusState) : ValidateLoginEvent()

    data class ChangeRRSSData(
        val idRRSS: String,
        val typeRRSS: String,
        val email: String,
        val name: String,
        val phoneNumber: String,
    ) : ValidateLoginEvent()

    object Login : ValidateLoginEvent()
    object ValidateDocument : ValidateLoginEvent()
}

