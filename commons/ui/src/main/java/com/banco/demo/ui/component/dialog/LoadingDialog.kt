package com.banco.demo.ui.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.banco.demo.ui.theme.NeutralDarkGreyWhite

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoadingDialog(
    showDialog: Boolean = false,
) {

    var showDialogProgress = showDialog

    if (showDialogProgress) {

        Dialog(
            onDismissRequest = { showDialogProgress = false },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
                usePlatformDefaultWidth = false)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(NeutralDarkGreyWhite.copy(alpha =0.4f )),
                contentAlignment = Alignment.Center
            ) {

                CircularProgressIndicator(
                    modifier = Modifier
                        .progressSemantics()
                        .size(50.dp),
                )

            }
        }
    }
}