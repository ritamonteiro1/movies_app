package com.example.designsystem.theme.sizes

data class MoviesAppSizes(
    val spacing: Space,
    val border: Border,
    val radius: Radius
) {
    companion object {
        val default = MoviesAppSizes(
            spacing = Space.default,
            border = Border.default,
            radius = Radius.default
        )
    }
}