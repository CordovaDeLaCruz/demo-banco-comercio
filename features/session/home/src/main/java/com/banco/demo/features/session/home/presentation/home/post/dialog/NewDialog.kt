package com.banco.demo.features.session.home.presentation.home.post.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.banco.demo.features.session.home.presentation.home.post.dialog.newpost.NewPostModalScreen
import com.banco.demo.ui.R
import com.banco.demo.ui.theme.NeutralDarkGreyWhite

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NewDialog(
    isShowEditDialog: Boolean = false,
    onClickClose: (() -> Unit)?,
    idUser: String,
) {

    var text by remember {
        mutableStateOf("")
    }


    var isShowEditDialogAux by remember {
        mutableStateOf(isShowEditDialog)
    }

    LaunchedEffect(key1 = isShowEditDialog) {
        isShowEditDialogAux = isShowEditDialog
    }

    if (isShowEditDialogAux) {
        Dialog(
            properties = DialogProperties(usePlatformDefaultWidth = false),
            onDismissRequest = { }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                IconButton(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .align(Alignment.End),
                    onClick = {
                        if (onClickClose != null) {
                            onClickClose()
                        }
                        isShowEditDialogAux = false
                    }) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_btn_edit_close),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    shape = RoundedCornerShape(8.dp),
                    color = NeutralDarkGreyWhite
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        NewPostModalScreen(
                            idUser = idUser
                        )
                    }
                }
            }
        }
    }
}