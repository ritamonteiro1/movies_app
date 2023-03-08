package com.example.designsystem.theme.apptheme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import com.example.designsystem.theme.colors.MoviesAppColors
import com.example.designsystem.theme.sizes.MoviesAppSizes
import com.example.designsystem.theme.typography.MoviesAppTypography

/**
 * Setup of [MaterialTheme]
 * @param colors - [MoviesAppColors] to be used as material [Colors]
 * @param typography - [MoviesAppTypography] to be used as material [Typography]
 * @param sizes - [MoviesAppSizes] to be used as material [Shapes]
 */
@Composable
fun MoviesAppTheme(
    colors: MoviesAppColors = defaultColorsBySystem(),
    typography: MoviesAppTypography = defaultTypographyBySystem(),
    sizes: MoviesAppSizes = MoviesAppSizes.default,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalMoviesAppColors provides colors,
        LocalMoviesAppTypography provides typography,
        LocalMoviesAppSizes provides sizes,
    ) {
        MaterialTheme(
            colors = LocalMoviesAppColors.current.material,
            typography = LocalMoviesAppTypography.current.material,
            shapes = LocalMoviesAppSizes.current.material,
            content = content
        )
    }
}

/**
 * This represents [MoviesAppColors]
 */
val LocalMoviesAppColors = compositionLocalOf {
    MoviesAppColors.light
}

/**
 * This represents [MoviesAppTypography]
 */
val LocalMoviesAppTypography = compositionLocalOf {
    MoviesAppTypography.light
}

/**
 * This represents [MoviesAppSizes]
 */
val LocalMoviesAppSizes = compositionLocalOf {
    MoviesAppSizes.default
}

/**
 * Identify if dark mode is enabled in the device settings and returns a mode from [MoviesAppColors]
 */
@Composable
private fun defaultColorsBySystem(): MoviesAppColors {
    return if (isSystemInDarkTheme()) {
        MoviesAppColors.dark
    } else {
        MoviesAppColors.light
    }
}

/**
 * Identify if dark mode is enabled in the device settings and returns a mode from [MoviesAppTypography]
 */
@Composable
private fun defaultTypographyBySystem(): MoviesAppTypography {
    return if (isSystemInDarkTheme()) {
        MoviesAppTypography.dark
    } else {
        MoviesAppTypography.light
    }
}

/**
 * Translates [MoviesAppColors] to material [Colors]
 */
val MoviesAppColors.material: Colors
    get() = Colors(
        primary = moviesColors.primary,
        primaryVariant = moviesColors.onPrimary,
        secondary = moviesColors.secondary,
        secondaryVariant = moviesColors.onSecondary,
        background = moviesColors.background,
        surface = moviesColors.surface,
        error = moviesColors.error,
        onPrimary = moviesColors.onPrimary,
        onSecondary = moviesColors.onSecondary,
        onBackground = moviesColors.onBackground,
        onSurface = moviesColors.onSurface,
        onError = moviesColors.onError,
        isLight = isLight
    )

/**
 * Translates [MoviesAppTypography] to material [Typography]
 */
val MoviesAppTypography.material: Typography
    get() = Typography(
        h1 = h1,
        h2 = h2,
        h3 = h3,
        h4 = h4,
        h5 = h5,
        h6 = h6,
        subtitle1 = h1,
        subtitle2 = h2,
        body1 = h3,
        body2 = h1,
        button = h2,
        caption = h3,
        overline = h1,
    )

/**
 * Translates [MoviesAppSizes] to material [Shapes]
 */
val MoviesAppSizes.material: Shapes
    get() = Shapes(
        small = RoundedCornerShape(radius.x100),
        medium = RoundedCornerShape(radius.x200),
        large = RoundedCornerShape(radius.x300)
    )