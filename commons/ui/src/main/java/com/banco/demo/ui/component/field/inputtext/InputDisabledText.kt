package com.banco.demo.ui.component.field.inputtext

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banco.demo.ui.R
import com.banco.demo.ui.theme.*

@Composable
fun InputDisabledText(
    modifier: Modifier = Modifier,
    label: String,
    hint: String,
    value: String = "",
    error: Int = -1,
    maxChar: Int = -1,
    prefix: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isHintVisible: Boolean = true,
    onFocusChange: (FocusState) -> Unit,
    onValueChange: (String) -> Unit,
) {


    var showPassword by remember {
        mutableStateOf(false)
    }

    var keyboardTypeAux by remember {
        mutableStateOf(keyboardType)
    }

    var visualTransformationAux by remember {
        mutableStateOf(visualTransformation)
    }

    LaunchedEffect(key1 = keyboardType) {
        keyboardTypeAux = keyboardType
    }

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.caption,
            color = PrimaryPurpleDarkest
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .background(NeutralLightGreyLightestWhite)
                .border(
                    BorderStroke(
                        1.dp,
                        NeutralDarkGreyLight
                    ), RoundedCornerShape(8.dp)
                )

                .padding(horizontal = 16.dp),

        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                if (prefix.isNotEmpty()) {
                    Text(
                        text = prefix,
                        style = MaterialTheme.typography.caption.copy(color = NeutralDarkGreyNeutral)
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    BasicTextField(
                        enabled = false,
                        modifier = Modifier
                            .fillMaxWidth()
                            .onFocusChanged {
                                onFocusChange(it)
                            },
                        value = value,
                        maxLines = 1,
                        singleLine = true,
                        keyboardActions = KeyboardActions(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = keyboardTypeAux,
                            autoCorrect = false
                        ),
                        onValueChange = {
                            if (maxChar > 0) {
                                if (it.length <= maxChar) {
                                    onValueChange(it)
                                }
                            } else {
                                onValueChange(it)
                            }
                        },
                        visualTransformation = visualTransformationAux,
                        textStyle = MaterialTheme.typography.caption
                            .copy(
                                color = NeutralDarkGreyNeutral
                            ),
                    )
                    if (isHintVisible) {
                        Text(
                            text = hint,
                            style = MaterialTheme.typography.caption,
                            color = NeutralLightGreyDark
                        )
                    }
                }
                if (keyboardType == KeyboardType.NumberPassword || keyboardType == KeyboardType.Password) {
                    IconButton(
                        onClick = {
                            showPassword = !showPassword
                            if (showPassword) {
                                if (keyboardType == KeyboardType.Password) {
                                    keyboardTypeAux = KeyboardType.Text
                                } else {
                                    keyboardTypeAux = KeyboardType.Number
                                }
                                visualTransformationAux = VisualTransformation.None
                            } else {
                                keyboardTypeAux = keyboardType
                                visualTransformationAux = PasswordVisualTransformation()
                            }


                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_eyes),
                            contentDescription = stringResource(id = R.string.input_text_show_password_icon_cd),
                            tint = PrimaryPurpleDarkest
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        AnimatedVisibility(
            visible = error != -1,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            Text(
                text = if (error != -1) stringResource(id = error) else "",
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                color = ComplementaryRedDark
            )
        }
    }
}


@Preview(backgroundColor = 0xFFF4F7FF, showBackground = true)
@Composable
fun InputDisabledTextPreview() {
//    InputText(Modifier.fillMaxWidth(), "Titulo", "Indicación", "")
}