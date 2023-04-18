package com.banco.demo.ui.component.field.inputtext

import androidx.compose.ui.text.input.KeyboardType

data class InputTextState(
    val label: String = "",
    var text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true,
    val error: Int = -1,
    val state: String = "",
    val isFocused: Boolean = false,
    val maxChar: Int = -1,
    val prefix: String = "",
    val keyboardType: KeyboardType = KeyboardType.Text,
) {
    companion object {
        fun validateState(isError: Boolean, isFocused: Boolean): String {
            return if (isError) {
                InputTextViewState.Error.state
            } else if (isFocused) {
                InputTextViewState.Focus.state
            } else {
                InputTextViewState.Normal.state
            }
        }
    }
}
