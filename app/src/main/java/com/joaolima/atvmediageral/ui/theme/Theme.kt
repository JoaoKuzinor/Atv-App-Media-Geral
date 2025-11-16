package com.joaolima.atvmediageral.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = GreenPrimary,
    secondary = GreenSecondary,
    background = GreenBackground,
    surface = GreenSurface,
    onPrimary = GreenText,
    onSecondary = GreenText,
    onBackground = GreenText,
    onSurface = GreenText
)

@Composable
fun AtvMediaGeralTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}
