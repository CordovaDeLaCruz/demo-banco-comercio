package com.banco.demo.ui.component.field.button

import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.banco.demo.ui.theme.Gotham
import com.banco.demo.ui.theme.NeutralDarkGreyBlack
import com.banco.demo.ui.theme.PrimaryPurpleDarkest

@Composable
fun LinkButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = "",
) {

    Text(
        modifier = modifier
            .clickable {
                onClick()
            },
        text = text,
        style = MaterialTheme.typography.caption.copy(textDecoration = TextDecoration.Underline),
        color = NeutralDarkGreyBlack,
        fontFamily = Gotham,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    )
}


@Preview(backgroundColor = 0xFFF4F7FF, showBackground = true)
@Composable
fun LinkButtonPreview() {
    LinkButton(
        text = "Continuar",
        modifier = Modifier,
        onClick = {

        }
    )
}