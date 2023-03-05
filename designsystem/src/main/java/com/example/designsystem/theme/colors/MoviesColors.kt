package com.example.designsystem.theme.colors

import androidx.compose.ui.graphics.Color
import com.example.designsystem.theme.mode.Mode

data class MoviesColors(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val quaternary: Color,
    val quinary: Color,
    val background: Color,
    val onBackground: Color,
    val error: Color,
    val onError: Color,
    val surface: Color,
    val onSurface: Color,
    val onPrimary: Color,
    val onSecondary: Color,
    val onTertiary: Color,
    val onQuaternary: Color,
    val onQuinary: Color,
) {
    internal companion object : Mode<MoviesColors> {
        override val light = MoviesColors(
            primary = MyColors.yInMnBlue,
            secondary = MyColors.chineseViolet,
            tertiary = MyColors.cinnamonSatin,
            quaternary = MyColors.candyPink,
            quinary = MyColors.tumbleweed,
            background = MyColors.lightBackground,
            onBackground = MyColors.onLightBackground,
            error = MyColors.lightError,
            onError = MyColors.onLightError,
            surface = MyColors.lightSurface,
            onSurface = MyColors.onLightSurface,
            onPrimary = MyColors.onYInMnBlue,
            onSecondary = MyColors.onChineseViolet,
            onTertiary = MyColors.onCinnamonSatin,
            onQuaternary = MyColors.onCandyPink,
            onQuinary = MyColors.onTumbleweed,
        )
        override val dark = MoviesColors(
            primary = MyColors.babyBlueEyes,
            secondary = MyColors.mauve,
            tertiary = MyColors.cherryBlossomPink,
            quaternary = MyColors.lightPink,
            quinary = MyColors.macaroniAndCheese,
            background = MyColors.darkBackground,
            onBackground = MyColors.onDarkBackground,
            error = MyColors.darkError,
            onError = MyColors.onDarkError,
            surface = MyColors.darkSurface,
            onSurface = MyColors.onDarkSurface,
            onPrimary = MyColors.onBabyBlueEyes,
            onSecondary = MyColors.onMauve,
            onTertiary = MyColors.onCherryBlossomPink,
            onQuaternary = MyColors.onLightPink,
            onQuinary = MyColors.onMacaroniAndCheese,
        )
    }
}