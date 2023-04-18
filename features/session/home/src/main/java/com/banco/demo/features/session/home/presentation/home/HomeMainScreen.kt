package com.banco.demo.features.session.home.presentation.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.banco.demo.commons.libs.constants.navigation.HomeSessionNavScreen
import com.banco.demo.ui.component.dialog.LoadingDialog
import com.banco.demo.ui.theme.*
import kotlinx.coroutines.flow.collectLatest
import com.banco.demo.ui.component.dialog.alert.AlertDialog
import com.banco.demo.ui.R as UiR


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeMainViewModel = hiltViewModel(),
) {
    navController.context

    val context = LocalContext.current
    val alertDialogState = viewModel.alertDialog.value.copy()

    var showProgress by remember {
        mutableStateOf(false)
    }

    val personsState = viewModel.persons.value

    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) { scrollState.animateScrollTo(0) }

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is HomeMainViewModel.UiEvent.ShowError -> {
                    viewModel.onEvent(
                        HomeMainEvent.ShowDialog(
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
                is HomeMainViewModel.UiEvent.LoadingDialog -> {
                    showProgress = event.isShow
                }

            }
        }
    }

    LoadingDialog(showDialog = showProgress)

    AlertDialog(
        isShowDialog = alertDialogState.showDialog,
        title = alertDialogState.title,
        text = alertDialogState.text,
        textPrimary = alertDialogState.textPrimary,
        textSecondary = alertDialogState.textSecondary,
        onClickPrimary = {
            viewModel.onEvent(HomeMainEvent.ChangeIsShowDialog(false))
        },
        onClickSecondary = {

        },
        onClickClose = {
            viewModel.onEvent(HomeMainEvent.ChangeIsShowDialog(false))
        }
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
                ) {
                    Spacer(
                        modifier = Modifier
                            .height(18.dp)
                            .fillMaxWidth()
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        text = stringResource(id = UiR.string.list_persons),
                        style = TextStyle(
                            fontFamily = Gotham,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            lineHeight = 22.sp
                        ),
                        color = NeutralDarkGreyBlack,
                    )
                    Spacer(
                        modifier = Modifier
                            .height(12.dp)
                            .fillMaxWidth()
                    )
                }
            }
            items(
                count = personsState.persons.size,
            ) { index ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(NeutralDarkGreyWhite),
                ) {
                    val person = personsState.persons[index]
                    PersonItemHomeScreen(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 6.dp),
                        name = person.name,
                        userName = person.username,
                        email = person.email,
                        phone = person.phone,
                        onClickPosts = {
                            val map = HashMap<String, String>()
                            map["{id}"] = person.id.toString()
                            navController.navigate(
                                HomeSessionNavScreen.PostsNavScreen.witArgs(map)
                            )
                        }
                    )
                }
            }
        }
    }

}

