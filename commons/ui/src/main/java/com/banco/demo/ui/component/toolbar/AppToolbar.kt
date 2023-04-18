package com.banco.demo.ui.component.toolbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.banco.demo.ui.component.field.button.BackUnderlineButton
import com.banco.demo.ui.component.field.button.ExitButton
import com.banco.demo.ui.theme.*
import com.banco.demo.ui.R

@Composable
fun AppToolbar(
    state: String = AppToolbarState.Main.state,
    title: String = "",
    visibilityProfile: Boolean = false,
    onBack: () -> Unit,
    onClose: () -> Unit,
    onExit: () -> Unit,
    onProfile: () -> Unit,
    onNotification: () -> Unit,
    onMenu: () -> Unit,
) {


    Toolbar(
        height = when (state) {
            AppToolbarState.CloseLight.state,
            AppToolbarState.CloseDark.state,
            AppToolbarState.OnlyLogo.state,
            AppToolbarState.LogoAndBack.state,
            AppToolbarState.LogoAndExit.state,
            -> 56.dp
            AppToolbarState.Back.state,
            -> 40.dp
            AppToolbarState.OnlyClose.state,
            -> 36.dp
            AppToolbarState.Main.state,
            -> 64.dp
            else
            -> 56.dp
        },
        background = when (state) {
            AppToolbarState.CloseLight.state,
            -> PrimaryPurpleLightestWhiteBackground
            AppToolbarState.CloseDark.state,
            AppToolbarState.Back.state,
            -> PrimaryPurpleLightestWhite
            AppToolbarState.OnlyLogo.state,
            AppToolbarState.LogoAndBack.state,
            AppToolbarState.LogoAndExit.state,
            -> NeutralDarkGreyWhite
            AppToolbarState.OnlyClose.state,
            -> PrimaryPurpleDarkWhiteBackground
            AppToolbarState.Main.state,
            -> NeutralDarkGreyWhite
            else
            -> NeutralDarkGreyWhite
        },
        title = when (state) {
            AppToolbarState.CloseLight.state,
            AppToolbarState.CloseDark.state,
            -> {
                {
                    Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = 12.dp,
                                start = 12.dp
                            ),
                        text = title,
                        color = NeutralDarkGreyBlack,
                        style = MaterialTheme.typography.caption
                    )
                }
            }
            AppToolbarState.OnlyLogo.state,
            AppToolbarState.LogoAndBack.state,
            AppToolbarState.LogoAndExit.state,
            -> {
                {
                    Image(
                        painter = painterResource(id = R.drawable.ic_banco_comercio_splash),
                        contentDescription = stringResource(id = R.string.content_description_ic_logo),
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier.height(30.dp)
                    )
                }
            }
            AppToolbarState.Back.state,
            -> {
                {
                    Row(modifier = Modifier
                        .padding(start = 3.dp)
                        .fillMaxWidth()
                        .clickable {
                            onBack()
                        },
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = stringResource(id = R.string.content_description_ic_logo),
                            tint = NeutralDarkGreyBlack,
                            modifier = Modifier.size(9.dp, 10.dp)
                        )

                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = 12.dp
                                ),
                            text = title,
                            color = NeutralDarkGreyBlack,
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
            }
            AppToolbarState.OnlyClose.state,
            -> {
                {

                }
            }
            AppToolbarState.Main.state -> {
                {
                    Image(
                        painter = painterResource(id = R.drawable.ic_banco_comercio_splash),
                        contentDescription = stringResource(id = R.string.content_description_ic_logo),
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier.height(30.dp)
                    )
                }
            }
            else -> {
                {
                    Image(
                        painter = painterResource(id = R.drawable.ic_banco_comercio_splash),
                        contentDescription = stringResource(id = R.string.content_description_ic_logo),
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier.height(30.dp)
                    )
                }
            }
        },
        items = when (state) {
            AppToolbarState.CloseLight.state,
            AppToolbarState.CloseDark.state,
            -> {
                arrayListOf(
                    {
                        Box(
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .size(24.dp)
                                .clickable {
                                    onClose()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_close),
                                contentDescription = stringResource(id = R.string.content_description_ic_logo),
                                tint = NeutralDarkGreyBlack
                            )
                        }
                    }
                )
            }
            AppToolbarState.OnlyClose.state,
            -> {
                arrayListOf(
                    {
                        Box(
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .size(24.dp)
                                .clickable {
                                    onClose()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_close),
                                contentDescription = stringResource(id = R.string.content_description_ic_logo),
                                tint = NeutralDarkGreyBlack
                            )
                        }
                    }
                )
            }
            AppToolbarState.OnlyLogo.state,
            -> {
                arrayListOf()
            }
            AppToolbarState.LogoAndBack.state,
            -> {
                arrayListOf({
                    Box(modifier = Modifier
                        .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        BackUnderlineButton(
                            onClick = onBack
                        )
                    }
                })
            }
            AppToolbarState.LogoAndExit.state,
            -> {
                arrayListOf({
                    Box(modifier = Modifier
                        .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        ExitButton(
                            onClick = onExit
                        )
                    }
                })
            }
            AppToolbarState.Back.state,
            -> {
                arrayListOf()
            }
            AppToolbarState.Main.state,
            -> {
                arrayListOf(
                    /*{
                        Box(modifier = Modifier
                            .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Box(modifier = Modifier
                                .width(28.dp)
                                .height(24.dp)
                                .clickable {
                                    onNotification()
                                }
                            )
                            {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_alarm),
                                    contentDescription = stringResource(id = R.string.content_description_ic_logo),
                                    tint = PrimaryPurpleDarkest,
                                    modifier = Modifier.size(24.dp)

                                )
                                Box(
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .size(8.dp)
                                        .clip(CircleShape)
                                        .background(ComplementaryOliveDarkest)
                                )
                            }
                        }
                    },*/
                    {
                        Box(modifier = Modifier
                            .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Row(
                                modifier = Modifier
                                    .clickable {
                                        onProfile()
                                    }
                            ) {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://fundaciontem.org/wp-content/uploads/2016/04/sinay-segun-veronica-1.jpg")
                                        .crossfade(true)
                                        .build(),
                                    error = painterResource(R.drawable.ic_only_logo),
                                    placeholder = painterResource(R.drawable.ic_only_logo),
                                    contentDescription = stringResource(R.string.content_description_ic_logo),
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .size(28.dp)
                                )
                                Icon(
                                    painter = painterResource(id =if( visibilityProfile)  R.drawable.ic_btn_arrow_up else R.drawable.ic_btn_arrow_down),
                                    contentDescription = stringResource(id = R.string.content_description_ic_logo),
                                    tint = NeutralDarkGreyBlack,
                                    modifier = Modifier.size(24.dp)

                                )
                            }
                        }
                    },
                    /*{
                        Box(modifier = Modifier
                            .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_menu_burger),
                                contentDescription = stringResource(id = R.string.content_description_ic_logo),
                                tint = PrimaryPurpleDarkest,
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable {
                                        onMenu()
                                    }
                            )
                        }
                    },*/
                )
            }
            else -> {
                arrayListOf()
            }
        }

    )


}