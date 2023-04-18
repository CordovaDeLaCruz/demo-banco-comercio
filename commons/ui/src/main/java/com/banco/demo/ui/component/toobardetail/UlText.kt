package com.banco.demo.ui.component.toobardetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banco.demo.ui.R
import com.banco.demo.ui.theme.Gotham
import com.banco.demo.ui.theme.PrimaryPurpleDarkest

@Composable
fun UlText(
    text: String = stringResource(id = R.string.profile_contact_title),
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_blue_point),
            contentDescription = stringResource(id = R.string.ul_text_icon),
            tint = PrimaryPurpleDarkest
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = TextStyle(
                fontFamily = Gotham,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp),

            color = PrimaryPurpleDarkest,
        )
    }

}


@Preview(backgroundColor = 0xFFF4F7FF, showBackground = true)
@Composable
fun LinkUlTextPreview() {
    UlText(
        text = "Mi perfil",
    )
}