package com.banco.demo.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.banco.demo.ui.R


//Set fonts
val Gotham = FontFamily(
    Font(R.font.gotham_thin, weight = FontWeight.Thin),
    Font(R.font.gotham_xlight, weight = FontWeight.ExtraLight),
    Font(R.font.gotham_light, weight = FontWeight.Light),
    Font(R.font.gotham_book, weight = FontWeight.Normal),
    Font(R.font.gotham_medium, weight = FontWeight.Medium),
    Font(R.font.gotham_bold, weight = FontWeight.Bold),
    Font(R.font.gotham_black, weight = FontWeight.Black),

    )

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Medium,
        fontSize = 40.sp,
        lineHeight = 40.sp,
    ),
    h2 = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Medium,
        fontSize = 32.sp,
        lineHeight = 40.sp,
    ),
    h3 = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 32.sp,
    ),
    h4 = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 16.sp,
    ),
    h5 = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    button = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    caption = TextStyle(
        fontFamily = Gotham,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
)


val TypeHeadlineGothamLight32px = TextStyle(
    fontFamily = Gotham,
    fontWeight = FontWeight.Light,
    fontSize = 32.sp,
    lineHeight = 40.sp
)

val TypeIndicatorGothamMedium = TextStyle(
    fontFamily = Gotham,
    fontWeight = FontWeight.Medium,
    fontSize = 10.sp,
    lineHeight = 12.sp
)

val TypeIndicatorGothamMedium8px = TextStyle(
    fontFamily = Gotham,
    fontWeight = FontWeight.Medium,
    fontSize = 8.sp,
    lineHeight = 8.sp
)


val TypeIndicatorGothamBook8px = TextStyle(
    fontFamily = Gotham,
    fontWeight = FontWeight.Normal,
    fontSize = 8.sp,
    lineHeight = 8.sp
)

val TypeIndicatorGothamBook10px = TextStyle(
    fontFamily = Gotham,
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
    lineHeight = 12.sp
)



val TypeCaption2 = TextStyle(
    fontFamily = Gotham,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 16.sp
)
val TypeCaptionBook = TextStyle(
    fontFamily = Gotham,
    fontWeight = FontWeight.Light,
    fontSize = 12.sp,
    lineHeight = 16.sp
)

val TypeTitle = TextStyle(
    fontFamily = Gotham,
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp,
    lineHeight = 28.sp,
    color = PrimaryPurpleDarkest
)

val TypeDescription = TextStyle(
    fontFamily = Gotham,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    color = PrimaryBlueDarkest
)

val TypeParagraph = TextStyle(
    fontFamily = Gotham,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    color = PrimaryBlueDarkest
)