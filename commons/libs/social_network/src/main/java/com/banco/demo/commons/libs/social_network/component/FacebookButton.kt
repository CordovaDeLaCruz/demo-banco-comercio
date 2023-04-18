package com.banco.demo.commons.libs.social_network.component

import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.google.firebase.auth.FirebaseAuth
import com.banco.demo.commons.libs.social_network.*
import com.banco.demo.ui.theme.FacebookBackground
import com.banco.demo.ui.theme.FacebookText
import com.banco.demo.ui.theme.Gotham
import com.banco.demo.ui.theme.NeutralDarkGreyWhite

@Composable
fun FacebookButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        modifier = modifier.defaultMinSize(
            minWidth = 115.dp,
            minHeight = 44.dp
        ),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(
            14.dp
        ),
        onClick = {
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = FacebookBackground,
            disabledBackgroundColor = FacebookBackground
        )
    )
    {

        Icon(
            modifier = Modifier.padding(end = 8.dp),
            painter = painterResource(id = R.drawable.ic_social_media_facebook),
            tint = NeutralDarkGreyWhite,
            contentDescription = stringResource(R.string.content_description_ic_social_media_facebook),
        )

        Text(
            text = stringResource(R.string.facebook),
            color = FacebookText,
            fontFamily = Gotham,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 16.sp

        )
    }
}
