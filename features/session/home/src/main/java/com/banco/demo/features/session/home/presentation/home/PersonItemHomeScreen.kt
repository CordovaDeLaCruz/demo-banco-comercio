package com.banco.demo.features.session.home.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banco.demo.ui.theme.*
import com.banco.demo.ui.R as UiR

@Composable
fun PersonItemHomeScreen(
    modifier: Modifier = Modifier,
    name: String,
    userName: String,
    email: String,
    phone: String,
    onClickPosts: () -> Unit,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        elevation = 0.dp,
        backgroundColor = (PrimaryPurpleLightestWhite)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = stringResource(UiR.string.item_name, name),
                                textAlign = TextAlign.Start,
                                style = TextStyle(
                                    fontFamily = Gotham,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp
                                ),
                                color = NeutralDarkGreyBlack)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = stringResource(UiR.string.item_user_name, userName),
                                textAlign = TextAlign.Start,
                                style = TextStyle(
                                    fontFamily = Gotham,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp
                                ),
                                color = NeutralDarkGreyBlack
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = stringResource(UiR.string.item_email, email),
                                textAlign = TextAlign.Start,
                                style = TextStyle(
                                    fontFamily = Gotham,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 10.sp,
                                    lineHeight = 12.sp
                                ),
                                color = NeutralDarkGreyBlack
                            )
                            Text(
                                text = stringResource(UiR.string.item_phone, phone),
                                textAlign = TextAlign.Start,
                                style = TextStyle(
                                    fontFamily = Gotham,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 10.sp,
                                    lineHeight = 12.sp
                                ),
                                color = NeutralDarkGreyBlack
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Spacer(
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .height(1.dp)
                            .background(NeutralDarkGreyWhite)
                            .fillMaxWidth())
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .fillMaxWidth()
                            .clickable { onClickPosts() },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = stringResource(UiR.string.item_go_to_post),
                            textAlign = TextAlign.Start,
                            style = TextStyle(
                                fontFamily = Gotham,
                                fontWeight = FontWeight.Medium,
                                fontSize = 10.sp,
                                lineHeight = 12.sp
                            ),
                            color = NeutralDarkGreyBlack
                        )
                        Icon(
                            painter = painterResource(id = UiR.drawable.ic_arrow_right),
                            contentDescription = null,
                            tint = NeutralDarkGreyBlack
                        )
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PersonItemHomeScreenPreview() {
    PersonItemHomeScreen(
        name = "Erick Cordova",
        userName = "erickcd57",
        email = "erickcd57@gmail.com",
        phone = "941773653",
        onClickPosts = { }
    )
}