package com.banco.demo.ui.component.field.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banco.demo.ui.theme.Gotham
import com.banco.demo.ui.theme.NeutralDarkGreyWhite
import com.banco.demo.ui.theme.PrimaryBlueDark
import com.banco.demo.ui.theme.PrimaryBlueLight

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = "",
    enabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(
        start = 24.dp,
        top = 12.dp,
        end = 24.dp,
        bottom = 12.dp
    ),
) {

    Button(
        modifier = modifier
            .defaultMinSize(
                minWidth = ButtonDefaults.MinWidth,
                minHeight = 40.dp
            )
            .wrapContentWidth(),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        contentPadding =contentPadding,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = PrimaryBlueDark,
            disabledBackgroundColor = PrimaryBlueLight
        ),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
    )
    {
        Text(
            text = text,
            color = NeutralDarkGreyWhite,
            fontFamily = Gotham,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 16.sp

        )
    }
}


@Preview(backgroundColor = 0xFFF4F7FF, showBackground = true)
@Composable
fun SecondaryButtonPreview() {
    SecondaryButton(
        text = "Continuar",
        modifier = Modifier,
        onClick = {

        }
    )
}