package com.banco.demo.features.session.home.presentation.home.post.dialog.newpost

import android.util.Log
import androidx.compose.foundation.layout.*
import com.banco.demo.ui.theme.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.banco.demo.features.session.home.presentation.home.post.PostEvent
import com.banco.demo.features.session.home.presentation.home.post.PostViewModel
import com.banco.demo.ui.component.field.button.PrimaryButton
import com.banco.demo.ui.component.field.inputtext.InputText
import kotlinx.coroutines.flow.collectLatest
import com.banco.demo.ui.R as UiR

@Composable
fun NewPostModalScreen(
    viewModel: NewPostViewModel = hiltViewModel(),
    viewModelPostList: PostViewModel = hiltViewModel(),
    idUser: String,
) {

    val context = LocalContext.current

    val fieldsInvalidState = viewModel.fieldsInvalid

    val titleState = viewModel.title.value.copy(
        label = stringResource(id = UiR.string.modal_new_post_title),
        hint = stringResource(id = UiR.string.modal_new_post_title),
    )

    val descriptionState = viewModel.description.value.copy(
        label = stringResource(id = UiR.string.modal_new_post_description),
        hint = stringResource(id = UiR.string.modal_new_post_description),
    )

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is NewPostViewModel.UiEvent.ShowError -> {
                    viewModel.onEvent(
                        NewPostEvent.ShowDialog(
                            code = event.code,
                            title = event.title.asString(context),
                            message = event.text.asString(context)
                        )
                    )
                }
                is NewPostViewModel.UiEvent.SuccessCreation -> {
                    viewModelPostList.onEvent(PostEvent.DismissNewDialog)
                    viewModelPostList.onEvent(PostEvent.FindGetPosts)
                }
            }
        }
    }

    LaunchedEffect(key1 = idUser) {
        viewModel.initIdUser(idUser)
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(28.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = stringResource(id = UiR.string.modal_create_post_title),
            style = TextStyle(
                fontFamily = Gotham,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                lineHeight = 28.sp
            ),
            color = NeutralDarkGreyBlack,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(28.dp))
        InputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            label = titleState.label,
            hint = titleState.hint,
            value = titleState.text,
            error = titleState.error,
            state = titleState.state,
            keyboardType = KeyboardType.Text,
            isHintVisible = titleState.isHintVisible,
            onValueChange = {
                viewModel.onEvent(NewPostEvent.EnteredTitle(it))
            },
            onFocusChange = {
                viewModel.onEvent(NewPostEvent.ChangeTitleFocus(it))
            },
        )

        Spacer(modifier = Modifier.height(28.dp))
        InputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            label = descriptionState.label,
            hint = descriptionState.hint,
            value = descriptionState.text,
            error = descriptionState.error,
            state = descriptionState.state,
            keyboardType = KeyboardType.Text,
            isHintVisible = descriptionState.isHintVisible,
            onValueChange = {
                viewModel.onEvent(NewPostEvent.EnteredDescription(it))
            },
            onFocusChange = {
                viewModel.onEvent(NewPostEvent.ChangeDescriptionFocus(it))
            },
        )

        Spacer(modifier = Modifier.height(28.dp))

        PrimaryButton(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            text = stringResource(id = UiR.string.modal_new_post_btn_save),
            onClick = {
                      viewModel.onEvent(NewPostEvent.CreatePost)
            },
            enabled = fieldsInvalidState.size == 0,
        )
        Spacer(modifier = Modifier.height(28.dp))
    }
}