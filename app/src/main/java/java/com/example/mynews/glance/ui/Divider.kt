package java.com.example.mynews.glance.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.background
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.unit.ColorProvider
import java.com.example.mynews.glance.ui.theme.MyNewsGlanceColorScheme

@Composable
fun Divider(thickness: Dp = DividerDefaults.thickness, color: ColorProvider = DividerDefaults.color) {
    Spacer(
        modifier = GlanceModifier
            .fillMaxWidth()
            .height(thickness)
            .background(color),
    )
}

object DividerDefaults {
    val thickness: Dp = 1.dp
    val color: ColorProvider @Composable get() = MyNewsGlanceColorScheme.outlineVariant
}