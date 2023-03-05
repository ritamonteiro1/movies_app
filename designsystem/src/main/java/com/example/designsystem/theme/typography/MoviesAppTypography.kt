package com.example.designsystem.theme.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.designsystem.theme.mode.Mode

data class MoviesAppTypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val h5: TextStyle,
    val h6: TextStyle,
) {

    internal companion object : Mode<MoviesAppTypography> {
        override val light = MoviesAppTypography(

            h1 = MoviesTypography.h1Light,

            h2 = MoviesTypography.h2Light,

            h3 = MoviesTypography.h3Light,

            h4 = MoviesTypography.h4Light,

            h5 = MoviesTypography.h5Light,

            h6 = MoviesTypography.h6Light,
        )
        override val dark = MoviesAppTypography(

            h1 = MoviesTypography.h1Dark,

            h2 = MoviesTypography.h2Dark,

            h3 = MoviesTypography.h3Dark,

            h4 = MoviesTypography.h4Dark,

            h5 = MoviesTypography.h5Dark,

            h6 = MoviesTypography.h6Dark,
        )
    }
}

val TextStyle.bold: TextStyle get() = copy(fontWeight = FontWeight.Bold)