package com.banco.demo.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val DarkColorPalette = darkColors(
    primary = PrimaryPurpleDarkest,
    background = PrimaryPurpleLightestWhiteBackground,
    onBackground = Color.Red,
    surface = PrimaryPurpleLightestWhite,
    onSurface = PrimaryPurpleLightestWhite
)

private val LightColorPalette = lightColors(
    primary = PrimaryPurpleDarkest,
    background = PrimaryPurpleLightestWhiteBackground,
    onBackground = PrimaryPurpleLightestWhiteBackground,
    surface = PrimaryPurpleLightestWhite,
    onSurface = PrimaryPurpleLightestWhite

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)


@Composable
fun BancoDemoAppTheme(darkTheme: Boolean = true, content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }


    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
    

}