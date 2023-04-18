package com.banco.demo.ui.component.field.inputtext

sealed class InputTextViewState(var state: String) {
    object Normal : InputTextViewState("Normal")
    object Focus : InputTextViewState("Focus")
    object Error : InputTextViewState("Error")

}