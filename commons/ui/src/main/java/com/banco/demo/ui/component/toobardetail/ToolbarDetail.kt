package com.banco.demo.ui.component.toobardetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banco.demo.ui.R
import com.banco.demo.ui.theme.PrimaryPurpleDarkest
import com.banco.demo.ui.theme.PrimaryPurpleLightestWhite


@Composable
fun ToolbarDetail(
    onCloseClick: () -> Unit,
    backgroundColor: Color = PrimaryPurpleLightestWhite,
    titleText: String = stringResource(id = R.string.profile_contact_title)
) {


    Row(
        modifier = Modifier
            .background(color = backgroundColor)
            .fillMaxWidth()
            .height(56.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {

        TitleText(
            text = titleText
        )

        IconButton(
            modifier = Modifier.
            then(Modifier.size(16.dp)),
            onClick = { onCloseClick() }
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = stringResource(id = R.string.content_description_ic_toolbar_close),
                tint = PrimaryPurpleDarkest)
        }

    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ToolbarDetail(
        backgroundColor = PrimaryPurpleLightestWhite,
        onCloseClick = {

        }
    )
}