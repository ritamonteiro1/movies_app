package com.example.core.ui.theme

import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color


val LightColorPalette = lightColors(
    primary = LightColors.yInMnBlue,
    primaryVariant = LightColors.chineseViolet,
    secondary = LightColors.cinnamonSatin,
    secondaryVariant = LightColors.candyPink,
    background = LightColors.background,
    surface = LightColors.surface,
    error = LightColors.error,
    onPrimary = LightColors.onSurface,
    onSecondary = LightColors.onSurface,
    onBackground = LightColors.onBackground,
    onSurface = LightColors.onSurface,
    onError = LightColors.onError
)

val DarkColorPalette = lightColors(
    primary = DarkColors.babyBlueEyes,
    primaryVariant = DarkColors.mauve,
    secondary = DarkColors.cherryBlossomPink,
    secondaryVariant = DarkColors.lightPink,
    background = DarkColors.background,
    surface = DarkColors.surface,
    error = DarkColors.error,
    onPrimary = DarkColors.onSurface,
    onSecondary = DarkColors.onSurface,
    onBackground = DarkColors.onBackground,
    onSurface = DarkColors.onSurface,
    onError = DarkColors.onError
)

private object LightColors{
    val yInMnBlue = Color(0XFF355070)
    val chineseViolet = Color(0xFF6D597A)
    val cinnamonSatin = Color(0xFFB56576)
    val candyPink = Color(0xFFE56B6F)
//    val tumbleweed = Color(0xFFEAAC8B)

    val surface = Color(0xFFFDFCFF)
    val onSurface = Color(0xFF1A1C1E)
    val error = Color(0xFFBA1A1A)
    val onError = Color(0xFFFFFFFF)
    val background = Color(0xFFFDFCFF)
    val onBackground = Color(0xFF1A1C1E)
}

private object DarkColors{
    val babyBlueEyes = Color(0xFFA0C9FF)
    val mauve = Color(0xFFE2B6FF)
    val cherryBlossomPink = Color(0xFFFFB1C0)
    val lightPink = Color(0xFFFFB3B3)
//    val macaroniAndCheese = Color(0xFFFFB68F)

    val surface = Color(0xFF1A1C1E)
    val onSurface = Color(0xFFE3E2E6)
    val error = Color(0xFFFFB4AB)
    val onError = Color(0xFF690005)
    val background = Color(0xFF1A1C1E)
    val onBackground = Color(0xFFE3E2E6)
}