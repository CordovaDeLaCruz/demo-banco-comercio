package com.banco.demo.ui.component.dialog.alert

sealed class AlertDialogViewState(var state: String) {
    object Confirm : AlertDialogViewState("Confirm")
    object Error : AlertDialogViewState("Error")
    object Info : AlertDialogViewState("Info")

}