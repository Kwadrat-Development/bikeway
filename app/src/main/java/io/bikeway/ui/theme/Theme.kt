package io.bikeway.ui.theme

import androidx.activity.ComponentActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

@Composable
fun BikewayTheme(content: @Composable () -> Unit) {
    val activity = LocalContext.current as ComponentActivity
    SideEffect {
        activity.window.statusBarColor = ColorPalette.background.toArgb()
        activity.window.navigationBarColor = ColorPalette.background.toArgb()
    }

    MaterialTheme(
        content = content
    )
}