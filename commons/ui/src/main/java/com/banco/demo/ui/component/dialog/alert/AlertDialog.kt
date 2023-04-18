package com.banco.demo.ui.component.dialog.alert

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.banco.demo.ui.R
import com.banco.demo.ui.component.field.button.PrimaryButton
import com.banco.demo.ui.component.field.button.SecondaryButton
import com.banco.demo.ui.theme.*


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AlertDialog(
    isShowDialog: Boolean = false,
    state: String = AlertDialogViewState.Error.state,
    title: String? = stringResource(id = R.string.alert_dialog_title_default),
    text: String? = "",
    onClickClose: (() -> Unit),
    textPrimary: String? = stringResource(id = R.string.accept),
    onClickPrimary: (() -> Unit)? = null,
    textSecondary: String? = "",
    onClickSecondary: (() -> Unit)? = null,

    ) {


    val scrollState = rememberScrollState()

    if (isShowDialog) {
        Dialog(
            properties = DialogProperties(usePlatformDefaultWidth = false),
            onDismissRequest = { }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(NeutralDarkGreyWhite)
                        .clickable {
                            onClickClose()
                        }
                        .align(Alignment.End),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        modifier = Modifier.size(12.dp),
                        painter = painterResource(id = R.drawable.ic_close),
                        contentDescription = "Icon close",
                        tint = PrimaryPurpleDarkest
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(NeutralDarkGreyWhite)
                        .verticalScroll(scrollState),
                ) {

                    Spacer(modifier = Modifier.height(28.dp))

                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(PrimaryPurpleLightestWhiteBackground),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            painter = painterResource(
                                id = when (state) {
                                    AlertDialogViewState.Error.state -> R.drawable.ic_alert
                                    AlertDialogViewState.Confirm.state -> R.drawable.ic_help
                                    else -> R.drawable.ic_info

                                }
                            ),
                            contentDescription = stringResource(id = R.string.content_description_ic_logo),
                            tint = PrimaryPurpleDarkest
                        )

                    }
                    Spacer(modifier = Modifier.height(20.dp))


                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        text = if (title.isNullOrEmpty()) stringResource(id = R.string.alert_dialog_title_default) else title,
                        style = TypeTitle,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    if (!text.isNullOrEmpty()) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            text = text,
                            style = TypeDescription,
                            textAlign = TextAlign.Start
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        if (!textSecondary.isNullOrEmpty() || state == AlertDialogViewState.Confirm.state) {
                            SecondaryButton(
//                                    modifier = Modifier.weight(1f),
                                text = if (textSecondary.isNullOrEmpty()) stringResource(id = R.string.cancel) else textSecondary,
                                onClick = {
                                    if (onClickSecondary != null) {
                                        onClickSecondary()
                                    }
                                }
                            )
                        }

                        PrimaryButton(
//                                modifier = Modifier.weight(1f),
                            text = if (!textPrimary.isNullOrEmpty()) textPrimary else stringResource(
                                id = R.string.accept
                            ),
                            onClick = {
                                if (onClickPrimary != null) {
                                    onClickPrimary()
                                }
                            }
                        )

                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    if (state == AlertDialogViewState.Error.state) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(NeutralLightGreyLightestWhite)
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.weight(1f),
                                text = "Si tienes alguna duda o inconveniente,\ncomúnicate con nuestra asesora virtual Claudia",
                                style = TypeIndicatorGothamMedium
                                    .copy(textAlign = TextAlign.Start),
                                color = NeutralDarkGreyDarkest
                            )

                            Spacer(modifier = Modifier.width(8.dp))


                            Box(modifier = Modifier) {

                                Image(
                                    modifier = Modifier
                                        .padding(top = 4.dp)
                                        .size(24.dp)
                                        .clip(CircleShape)
                                        .border(BorderStroke(1.dp, ComplementaryClaudiaStroke))
                                        .background(NeutralLightGreyLightestWhite),
                                    painter = painterResource(id = R.drawable.ic_claudia),
                                    contentDescription = stringResource(id = R.string.content_description_ic_logo),
                                    contentScale = ContentScale.Fit,
                                )

                                Icon(
                                    modifier = Modifier
                                        .padding(start = 19.dp)
                                        .size(16.dp),
                                    painter = painterResource(id = R.drawable.ic_whatsapp),
                                    contentDescription = stringResource(
                                        id = R.string.content_description_ic_logo
                                    ),
                                    tint = PrimaryPurpleDarkest
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlertDialogPreview() {

}