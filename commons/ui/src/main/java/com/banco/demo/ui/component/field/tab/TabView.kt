package com.banco.demo.ui.component.field.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banco.demo.ui.theme.PrimaryPurpleDarkest
import com.banco.demo.ui.theme.PrimaryPurpleLightest

@Composable
fun TabView(text: String, selected: Boolean, background: Color = MaterialTheme.colors.background) {
    Column(
        Modifier
            .height(44.dp)
            .background(background),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text,
            Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.caption,
            color = if (selected) PrimaryPurpleDarkest else PrimaryPurpleLightest
        )
        Box(
            Modifier
                .padding(top = 4.dp)
                .height(1.dp)
                .fillMaxWidth()
                .border(1.dp, PrimaryPurpleLightest)
        )
    }
}


@Preview
@Composable
fun TabViewPreview() {
    TabView("Item", true)
}