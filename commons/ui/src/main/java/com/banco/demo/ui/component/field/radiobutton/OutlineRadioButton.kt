package com.banco.demo.ui.component.field.radiobutton

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banco.demo.ui.theme.*

@Composable
fun OutlineRadioButton(
    modifier: Modifier = Modifier,
    radioOptions: List<(@Composable () -> Unit)> = emptyList(),
    positionSelectedOption: Int?,
    onOptionSelectedOption: (Int) -> Unit,
    backgroundColor: Color = MaterialTheme.colors.surface,
) {


    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Column {
            radioOptions.forEachIndexed { index, it ->
                Card(
                    modifier = Modifier
                        .padding(vertical = 6.dp)
                        .fillMaxWidth()
                        .selectable(
                            selected = (index == positionSelectedOption),
                            onClick = { onOptionSelectedOption(index) }
                        ),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, PrimaryPurpleLightest),
                    backgroundColor = backgroundColor,
                    elevation = 0.dp
                ) {
                    Row(
                        modifier = Modifier
                            .height(IntrinsicSize.Min)
                            .fillMaxWidth(),
                    ) {


                        RadioButton(
                            selected = (index == positionSelectedOption),
                            onClick = {
                                onOptionSelectedOption(index)
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = PrimaryPurpleDarkest,
                                unselectedColor = PrimaryPurpleLight,
                                disabledColor = NeutralDarkGreyDark
                            ),
                        )
                        Box(modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                            contentAlignment = Alignment.CenterStart) {
                            it()
                        }
                    }
                }
            }
        }
    }
}


@Preview(backgroundColor = 0xFFF4F7FF, showBackground = true)
@Composable
fun OutlineRadioButtonPreview() {
//    RadioButton(
//        modifier = Modifier,
//
//        )
}