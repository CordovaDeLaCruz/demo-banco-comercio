package com.banco.demo.ui.component.toobardetail

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.banco.demo.ui.R
import com.banco.demo.ui.theme.Gotham
import com.banco.demo.ui.theme.PrimaryPurpleDarkest

@Composable
fun TitleText(
    text: String = stringResource(id = R.string.profile_contact_title),
) {

    Row(
    ) {

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
fun LinkTitleTextPreview() {
    TitleText(
        text = "Mi perfil",
    )
}