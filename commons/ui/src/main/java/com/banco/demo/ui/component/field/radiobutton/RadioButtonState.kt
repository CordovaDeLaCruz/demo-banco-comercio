package com.banco.demo.ui.component.field.radiobutton

data class RadioButtonState<T>(
    val radioOptions: List<T> = emptyList(),
    val selectedOption: T? = null,
) {
}
