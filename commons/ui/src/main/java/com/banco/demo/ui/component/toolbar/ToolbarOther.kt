package com.banco.demo.ui.component.toolbar

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banco.demo.ui.R
import com.banco.demo.ui.component.field.button.BackUnderlineButton
import com.banco.demo.ui.theme.NeutralDarkGreyWhite


@Composable
fun ToolbarOther(
    onBackClick: () -> Unit,
    isBackVisible: Boolean = true,
) {


    Row(
        modifier = Modifier
            .background(color = NeutralDarkGreyWhite)
            .fillMaxWidth()
            .height(56.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_banco_comercio_splash),
            contentDescription = stringResource(id = R.string.content_description_ic_logo),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.height(24.dp)
        )
        AnimatedVisibility(
            visible = isBackVisible,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            BackUnderlineButton(
                onClick = onBackClick
            )
        }

    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ToolbarOther(
        onBackClick = {

        }
    )
}