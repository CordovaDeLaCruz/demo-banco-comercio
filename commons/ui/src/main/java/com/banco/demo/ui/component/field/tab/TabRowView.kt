package com.banco.demo.ui.component.field.tab

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banco.demo.ui.theme.PrimaryPurpleDarkest


@Composable
fun TabRowView(
    modifier: Modifier = Modifier,
    items: List<String> = emptyList(),
    tabNum: Int = 0,
    background: Color = MaterialTheme.colors.background,
    onTabSelected: (String) -> Unit,
) {
    var tabNumAux by remember {
        mutableStateOf(tabNum)
    }
    LaunchedEffect(key1 = tabNum) {
        tabNumAux = tabNum
    }


    TabRow(
        tabNumAux,
        modifier,
        indicator = {
            Box(
                Modifier
                    .tabIndicatorOffset(it[tabNumAux])
                    .height(1.dp)
                    .border(1.dp, PrimaryPurpleDarkest)
            )
        }
    ) {
        for ((i, item) in items.withIndex()) {
            Tab(
                selected = tabNumAux == i,
                onClick = {
                    if (tabNumAux != i) {
                        onTabSelected(item)
                    }
                    tabNumAux = i

                }
            ) {
                TabView(item, tabNumAux == i, background)
            }
        }
    }
}


@Preview
@Composable
fun TabRowViewPreview() {
    TabRowView(
        Modifier.padding(24.dp), arrayListOf("Prueba", "Otro"),
        onTabSelected = { }
    )
}

