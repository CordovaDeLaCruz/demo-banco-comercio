package com.banco.demo.ui.component.field.radiobutton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.banco.demo.ui.R
import com.banco.demo.ui.theme.NeutralDarkGreyDark
import com.banco.demo.ui.theme.PrimaryPurpleDarkest
import com.banco.demo.ui.theme.PrimaryPurpleLight
import com.banco.demo.ui.theme.TypeDescription

@Composable
fun TermRadioButton(
    modifier: Modifier = Modifier,
    selectedOption: Any?,
    onOptionSelected: (Any) -> Unit,

    ) {
    val radioOptions: List<String> = listOf("Yes")

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Column {
            radioOptions.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = { onOptionSelected(text) }
                        )
                ) {

                    androidx.compose.material.RadioButton(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)

                        },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = PrimaryPurpleDarkest,
                            unselectedColor = PrimaryPurpleLight,
                            disabledColor = NeutralDarkGreyDark
                        ),
                    )

                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        text = buildAnnotatedString {
                            append(stringResource(id = R.string.radio_button_terms_accept))
                            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                                append(stringResource(id = R.string.radio_button_terms_conditions))
                            }
                            append(stringResource(id = R.string.radio_button_terms_and))
                            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                                append(stringResource(id = R.string.radio_button_terms_policies))
                            }
                        },
                        style = TypeDescription,
                        color = PrimaryPurpleDarkest
                    )
                }
            }
        }
    }
}


@Preview(backgroundColor = 0xFFF4F7FF, showBackground = true)
@Composable
fun TermRadioButtonPreview() {

}