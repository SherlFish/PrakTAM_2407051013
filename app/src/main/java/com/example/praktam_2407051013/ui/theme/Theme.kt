package com.example.praktam_2407051013.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val AppColorScheme = lightColorScheme(
    primary = RedPrimary,
    secondary = RedSecondary,
    background = LightBackground,
    surface = CardSurface,
    onPrimary = TextOnPrimary
)

@Composable
fun PrakTAM_2407051013Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = AppTypography,
        content = content
    )
}