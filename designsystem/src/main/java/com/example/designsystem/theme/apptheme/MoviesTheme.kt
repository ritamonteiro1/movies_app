package com.example.designsystem.theme.apptheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.example.designsystem.theme.colors.MoviesAppColors
import com.example.designsystem.theme.sizes.MoviesAppSizes
import com.example.designsystem.theme.typography.MoviesAppTypography

/**
 * Contains functions to access the theme values not supported by Material Design
 */
object MoviesTheme {

    val colors: MoviesAppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalMoviesAppColors.current

    val typography: MoviesAppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalMoviesAppTypography.current

    val sizes: MoviesAppSizes
        @Composable
        @ReadOnlyComposable
        get() = LocalMoviesAppSizes.current
}