package com.banco.demo.commons.libs.social_network.component

import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import com.banco.demo.ui.theme.GoogleBackground
import com.banco.demo.ui.theme.GoogleText
import com.banco.demo.ui.theme.Gotham

@Composable
fun GoogleButton(
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
            backgroundColor = GoogleBackground,
            disabledBackgroundColor = GoogleBackground
        )
    )
    {

        Image(
            modifier = Modifier.padding(end = 8.dp),
            painter = painterResource(id = R.drawable.ic_social_media_google),
            contentDescription = stringResource(R.string.content_description_ic_social_media_google),
        )

        Text(
            text = stringResource(R.string.google),
            color = GoogleText,
            fontFamily = Gotham,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 16.sp

        )
    }
}
