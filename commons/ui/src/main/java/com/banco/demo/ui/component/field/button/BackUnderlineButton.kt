package com.banco.demo.ui.component.field.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.banco.demo.ui.R
import com.banco.demo.ui.theme.Gotham
import com.banco.demo.ui.theme.PrimaryBlueDarkest

@Composable
fun BackUnderlineButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = stringResource(id = R.string.back),
) {
    var rowSize by remember { mutableStateOf(Size.Zero) }

    Row(
        modifier = Modifier
            .clickable { onClick() }
    ) {

        Icon(
            modifier = Modifier.padding(top = 4.dp),
            painter = painterResource(id = R.drawable.ic_toolbar_back),
            contentDescription = stringResource(id = R.string.content_description_ic_toolbar_back),
            tint = PrimaryBlueDarkest
        )

        Column(
            modifier = modifier
                .padding(start = 13.dp)
        ) {
            Text(
                modifier = modifier
                    .clickable {
                        onClick()
                    }
                    .onGloballyPositioned { layoutCoordinates ->
                        rowSize = layoutCoordinates.size.toSize()
                    },
                text = text,
                style = TextStyle(
                    fontFamily = Gotham,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    lineHeight = 16.sp),

                color = PrimaryBlueDarkest,
            )
            Divider(
                color = PrimaryBlueDarkest,
                modifier = Modifier
                    .width(with(LocalDensity.current) {
                        rowSize.width.toDp()
                    })
                    .height(1.dp)
            )
        }
    }

}


@Preview(backgroundColor = 0xFFF4F7FF, showBackground = true)
@Composable
fun BackUnderlineButtonPreview() {
    BackUnderlineButton(
        text = "Continuar",
        modifier = Modifier,
        onClick = {

        }
    )
}