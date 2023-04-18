package com.banco.demo.ui.component.dialog.alert

data class AlertDialogState(
    val showDialog: Boolean = false,
    val state: String = AlertDialogViewState.Error.state,
    val code: String? = "",
    val title: String? = "",
    val text: String? = "",
    val textPrimary: String? = "",
    val textSecondary: String? = "",
)
