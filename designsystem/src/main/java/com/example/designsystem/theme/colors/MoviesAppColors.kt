package com.example.designsystem.theme.colors

import com.example.designsystem.theme.mode.Mode

class MoviesAppColors(
    val colors: MoviesColors,
    val isLight: Boolean
) {
    internal companion object : Mode<MoviesAppColors> {
        override val light = MoviesAppColors(
            colors = MoviesColors.light,
            isLight = true,
        )
        override val dark = MoviesAppColors(
            colors = MoviesColors.dark,
            isLight = false,
        )
    }
}