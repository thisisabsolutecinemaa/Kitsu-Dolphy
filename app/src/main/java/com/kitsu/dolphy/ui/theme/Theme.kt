package com.kitsu.dolphy.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun KitsuDolphyTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val scheme: ColorScheme = if (darkTheme) {
        darkColorScheme(
            primary = KitsuColors.DarkPrimary,
            onPrimary = KitsuColors.DarkOnPrimary,
            primaryContainer = KitsuColors.DarkPrimaryContainer,
            onPrimaryContainer = KitsuColors.DarkOnPrimaryContainer,
            secondary = KitsuColors.DarkSecondary,
            onSecondary = KitsuColors.DarkOnSecondary,
            secondaryContainer = KitsuColors.DarkSecondaryContainer,
            onSecondaryContainer = KitsuColors.DarkOnSecondaryContainer,
            background = KitsuColors.BackgroundDark,
            surface = KitsuColors.SurfaceDark,
            error = Color(0xFFCF6679),
            onError = Color.Black
        )
    } else {
        lightColorScheme(
            primary = KitsuColors.LightPrimary,
            onPrimary = KitsuColors.LightOnPrimary,
            primaryContainer = KitsuColors.LightPrimaryContainer,
            onPrimaryContainer = KitsuColors.LightOnPrimaryContainer,
            secondary = KitsuColors.LightSecondary,
            onSecondary = KitsuColors.LightOnSecondary,
            secondaryContainer = KitsuColors.LightSecondaryContainer,
            onSecondaryContainer = KitsuColors.LightOnSecondaryContainer,
            background = KitsuColors.BackgroundLight,
            surface = KitsuColors.SurfaceLight,
            error = Color(0xFFB00020),
            onError = Color.White
        )
    }

    MaterialTheme(
        colorScheme = scheme,
        content = content
    )
}
