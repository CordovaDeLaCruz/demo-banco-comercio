package com.banco.demo.ui.component.field.button

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banco.demo.ui.theme.Gotham
import com.banco.demo.ui.theme.NeutralDarkGreyWhite
import com.banco.demo.ui.theme.PrimaryPurpleDarkest
import com.banco.demo.ui.theme.PrimaryPurpleLightest
import com.banco.demo.ui.R

@Composable
fun PrimaryIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = "",
    enabled: Boolean = true,
) {

    Button(
        modifier = modifier.defaultMinSize(
            minWidth = ButtonDefaults.MinWidth,
            minHeight = 40.dp
        ),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(
            start = 24.dp,
            top = 12.dp,
            end = 24.dp,
            bottom = 12.dp
        ),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = PrimaryPurpleDarkest,
            disabledBackgroundColor = PrimaryPurpleLightest
        )
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

        Spacer(modifier = Modifier.width(16.dp))

        Icon(
            modifier = Modifier.size(width = 14.dp, height = 9.dp),
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "Arrow right",
            tint = NeutralDarkGreyWhite
        )

    }
}


@Preview(backgroundColor = 0xFFF4F7FF, showBackground = true)
@Composable
fun PrimaryIconButtonPreview() {
    PrimaryButton(
        text = "Continuar",
        modifier = Modifier,
        onClick = {

        }
    )
}