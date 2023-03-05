package com.example.designsystem.theme.mode

interface Mode<T> {
    /**
     * The light mode
     */
    val light: T

    /**
     * The dark mode
     */
    val dark: T
}