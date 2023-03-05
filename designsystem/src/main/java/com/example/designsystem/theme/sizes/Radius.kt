package com.example.designsystem.theme.sizes

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Radius(
    val x100: Dp,
    val x200: Dp,
    val x300: Dp,
    ) {

    companion object {
        val default = Radius(
            x100 = 4.dp,
            x200 = 8.dp,
            x300 = 12.dp,
        )
    }
}