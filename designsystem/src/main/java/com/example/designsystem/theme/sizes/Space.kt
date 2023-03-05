package com.example.designsystem.theme.sizes

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Space (
    val sizeXXXXS: Dp,
    val sizeXXXS: Dp,
    val sizeXXS: Dp,
    val sizeXS: Dp,
    val sizeS: Dp,
    val size: Dp,
    val sizeM: Dp,
    val sizeL: Dp,
    val sizeXL: Dp,
    val sizeXXL: Dp,
    val sizeXXXL: Dp,
) {
    companion object {
        private val multiplier = 8.0.dp
        val default = Space(
            sizeXXXXS = multiplier / 2,
            sizeXXXS = multiplier,
            sizeXXS = multiplier * 2,
            sizeXS = multiplier * 3,
            sizeS = multiplier * 4,
            size = multiplier * 5,
            sizeM = multiplier * 6,
            sizeL = multiplier * 7,
            sizeXL = multiplier * 8,
            sizeXXL = multiplier * 9,
            sizeXXXL = multiplier * 10
        )
    }
}