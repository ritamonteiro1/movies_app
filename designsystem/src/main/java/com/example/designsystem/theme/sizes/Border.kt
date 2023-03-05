package com.example.designsystem.theme.sizes

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Border(
    val x100: Dp,
    val x200: Dp,
    val x300: Dp
) {
    companion object {
        val default = Border(
            x100 = 1.dp,
            x200 = 2.dp,
            x300 = 3.dp,
        )
    }
}