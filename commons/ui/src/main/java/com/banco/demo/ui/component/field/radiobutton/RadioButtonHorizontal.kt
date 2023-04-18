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
import androidx.compose.ui.tooling.preview.Preview
import com.banco.demo.ui.theme.NeutralDarkGreyDark
import com.banco.demo.ui.theme.PrimaryPurpleDarkest
import com.banco.demo.ui.theme.PrimaryPurpleLight
import com.banco.demo.ui.theme.TypeDescription

@Composable
fun RadioButtonHorizontal(
    modifier: Modifier = Modifier,
    radioOptions: List<Any> = emptyList(),
    selectedOption: Any?,
    onOptionSelected: (Any) -> Unit,
) {
    

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Row() {
            radioOptions.forEach { it ->
                Row(
                    Modifier
                        .weight(1f)
                        .selectable(
                            selected = (it == selectedOption),
                            onClick = { onOptionSelected(it) }
                        )
                ) {

                    androidx.compose.material.RadioButton(
                        selected = (it == selectedOption),
                        onClick = {
                            onOptionSelected(it)
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
                        text = it.toString(),
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
fun RadioButtonHorizontalPreview() {
//    RadioButton(
//        modifier = Modifier,
//
//        )
}