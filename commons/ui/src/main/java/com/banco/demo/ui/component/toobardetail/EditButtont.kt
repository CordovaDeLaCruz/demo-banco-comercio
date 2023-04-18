package com.banco.demo.ui.component.toobardetail

import androidx.compose.foundation.clickable
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
import com.banco.demo.ui.theme.PrimaryBlueDarkest

@Composable
fun EditButton(
    text: String = stringResource(id = R.string.edit),
    onClick: () -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onClick() }
    ) {

        Text(
            text = text,
            style = TextStyle(
                fontFamily = Gotham,
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp,
                lineHeight = 12.sp),

            color = PrimaryBlueDarkest,
        )
        Spacer(modifier = Modifier.width(9.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = stringResource(id = R.string.content_description_ic_toolbar_back),
            tint = PrimaryBlueDarkest
        )
    }

}


@Preview(backgroundColor = 0xFFF4F7FF, showBackground = true)
@Composable
fun LinkEditButtonPreview() {
    EditButton(
        text = "Editar",
        onClick = {

        }
    )
}