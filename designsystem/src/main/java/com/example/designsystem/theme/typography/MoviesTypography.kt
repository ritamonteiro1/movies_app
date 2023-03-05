package com.example.designsystem.theme.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.designsystem.theme.colors.MyColors

object MoviesTypography {

    val h1Light = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        color = MyColors.onLightSurface,
    )

    val h1Dark = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        color = MyColors.onDarkSurface,
    )

    val h2Light = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily.Default,
        color = MyColors.lightSurface,
    )


    val h2Dark = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily.Default,
        color = MyColors.darkSurface,
    )

    val h3Light = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily.Default,
        color = MyColors.onLightSurface,
    )

    val h3Dark = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily.Default,
        color = MyColors.onDarkSurface,
    );

    val h4Light = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily.Default,
        color = MyColors.onLightError,
    )

    val h4Dark = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily.Default,
        color = MyColors.onDarkError,
    );

    val h5Light = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily.Default,
        color = MyColors.onLightSurface,
    )
    val h5Dark = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        color = MyColors.onDarkSurface,
    )

    val h6Light = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily.Default,
        color = MyColors.onLightSurface,
    )

    val h6Dark = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily.Default,
        color = MyColors.onDarkSurface,
    )
}