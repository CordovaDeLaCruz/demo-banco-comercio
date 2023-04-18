package com.banco.demo.ui.component.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banco.demo.ui.theme.NeutralDarkGreyBlack
import com.banco.demo.ui.theme.PrimaryBlueLightest
import com.banco.demo.ui.theme.PrimarySkyBlueLightestWhite
import com.banco.demo.ui.theme.TypeIndicatorGothamBook8px
import com.banco.demo.ui.R

@Composable
fun InfoWidget(
    modifier: Modifier = Modifier,
    text: String,
) {
    Row(
        modifier = modifier.height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .width(8.dp)
            .fillMaxHeight()
            .clip(
                RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 0.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 8.dp
                )
            )
            .background(PrimaryBlueLightest)
        )

        Row(modifier = Modifier
            .weight(1f)
            .clip(
                RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 8.dp,
                    bottomEnd = 8.dp,
                    bottomStart = 0.dp
                )
            )
            .background(PrimarySkyBlueLightestWhite)
            .padding(start = 16.dp, top = 12.dp, end = 24.dp, bottom = 12.dp)

        ) {
            Icon(
                modifier = Modifier.size(12.dp),
                painter = painterResource(id = R.drawable.ic_alert),
                contentDescription = "Alert",
                tint = MaterialTheme.colors.primary
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                modifier = Modifier.weight(1f),
                text = text,
                style = TypeIndicatorGothamBook8px.copy(
                    fontSize = 10.sp,
                    lineHeight = 12.sp
                ),
                color = NeutralDarkGreyBlack
            )
        }
    }
}