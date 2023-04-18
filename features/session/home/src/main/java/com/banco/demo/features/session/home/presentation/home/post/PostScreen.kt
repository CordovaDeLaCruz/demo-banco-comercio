package com.banco.demo.features.session.home.presentation.home.post


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.banco.demo.features.session.home.presentation.home.post.dialog.NewDialog
import com.banco.demo.ui.component.dialog.LoadingDialog
import com.banco.demo.ui.theme.*
import kotlinx.coroutines.flow.collectLatest
import com.banco.demo.ui.component.dialog.alert.AlertDialog
import com.banco.demo.ui.component.field.button.PrimaryButton


@Composable
fun PostsScreen(
    navController: NavController,
    viewModel: PostViewModel = hiltViewModel(),
    id: String
) {
    navController.context

    viewModel.initId(id)

    val context = LocalContext.current
    val alertDialogState = viewModel.alertDialog.value.copy()

    var showProgress by remember {
        mutableStateOf(false)
    }

    val postState = viewModel.posts.value

    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) { scrollState.animateScrollTo(0) }

    val alertNewDialogState = viewModel.alertNewDialog.value.copy()


    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is PostViewModel.UiEvent.ShowError -> {
                    viewModel.onEvent(
                        PostEvent.ShowDialog(
                            code = event.code,
                            title = event.title.asString(context),
                            message = event.text.asString(context),
                            textPrimary = if (event.textPrimary != null) {
                                event.textPrimary!!.asString(context)
                            } else {
                                ""
                            },
                            textSecondary = if (event.textSecondary != null) {
                                event.textSecondary!!.asString(context)
                            } else {
                                ""
                            },
                        )
                    )
                }
                is PostViewModel.UiEvent.LoadingDialog -> {
                    showProgress = event.isShow
                }

            }
        }
    }

    AlertDialog(
        isShowDialog = alertDialogState.showDialog,
        title = alertDialogState.title,
        text = alertDialogState.text,
        textPrimary = alertDialogState.textPrimary,
        textSecondary = alertDialogState.textSecondary,
        onClickPrimary = {
            viewModel.onEvent(PostEvent.ChangeIsShowDialog(false))
        },
        onClickSecondary = {

        },
        onClickClose = {
            viewModel.onEvent(PostEvent.ChangeIsShowDialog(false))
        }
    )

    NewDialog(
        isShowEditDialog = alertNewDialogState.showNewDialog,
        onClickClose = {
            viewModel.onEvent(PostEvent.ChangeIsShowNewDialog(false))
        },
        idUser = id,
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoadingDialog(showDialog = showProgress)
        LazyColumn(
            contentPadding = PaddingValues(0.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(PrimaryPurpleLightestWhite),
        ){
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(NeutralDarkGreyWhite),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    PrimaryButton(
                        text = stringResource(id = com.banco.demo.ui.R.string.button_create_post),
                        modifier = Modifier,
                        onClick = {
                            viewModel.onEvent(
                                PostEvent.ShowNewDialog
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
            items(
                count = postState.posts.size,
            ) { index ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(NeutralDarkGreyWhite),
                ) {
                    val post = postState.posts[index]
                    PostItemScreen(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 6.dp),
                        title = post.title,
                        description = post.body
                    )
                }
            }
        }
    }

}

