package com.banco.demo.ui.component.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.banco.demo.ui.theme.NeutralDarkGreyWhite

@Composable
fun Toolbar(
    height: Dp = 54.dp,
    background: Color = NeutralDarkGreyWhite,
    title: (@Composable () -> Unit)? = null,
    items: List<(@Composable () -> Unit)> = emptyList(),
) {


    Row(
        modifier = Modifier
            .background(color = background)
            .fillMaxWidth()
            .height(height)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            title?.let {
                title()
            }
        }

        for (value in items) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(
                        start = 16.dp
                    ),
                contentAlignment = Alignment.TopStart,
            ) {
                value()
            }
        }
    }
}