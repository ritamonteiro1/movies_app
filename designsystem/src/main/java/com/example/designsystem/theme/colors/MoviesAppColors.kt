package com.example.designsystem.theme.colors

import com.example.designsystem.theme.mode.Mode

class MoviesAppColors(
    val moviesColors: MoviesColors,
    val isLight: Boolean
) {
    internal companion object : Mode<MoviesAppColors> {
        override val light = MoviesAppColors(
            moviesColors = MoviesColors.light,
            isLight = true,
        )
        override val dark = MoviesAppColors(
            moviesColors = MoviesColors.dark,
            isLight = false,
        )
    }
}