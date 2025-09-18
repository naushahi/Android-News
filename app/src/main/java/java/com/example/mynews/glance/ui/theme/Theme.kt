package java.com.example.mynews.glance.ui.theme

import androidx.glance.color.ColorProvider
import androidx.glance.material3.ColorProviders
import java.com.example.mynews.ui.theme.DarkColors
import java.com.example.mynews.ui.theme.LightColors

object MyNewsGlanceColorScheme {
    val colors = ColorProviders(
        light = LightColors,
        dark = DarkColors,
    )

    val outlineVariant = ColorProvider(
        day = LightColors.onSurface.copy(alpha = 0.1f),
        night = DarkColors.onSurface.copy(alpha = 0.1f),
    )
}