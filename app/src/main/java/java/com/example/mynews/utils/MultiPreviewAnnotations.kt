package java.com.example.mynews.utils

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "small font",
    group = "font scales",
    fontScale = 0.5f,
)
@Preview(
    name = "large font",
    group = "font scales",
    fontScale = 1.5f,
)
annotation class FontScalePreviews

@Preview(
    name = "phone",
    group = "devices",
    device = "spec:width=640dp,height=360dp,dpi=480",
)
@Preview(
    name = "foldable",
    group = "devices",
    device = "spec:width=673dp,height=841dp,dpi=480",
)
@Preview(
    name = "tablet",
    group = "devices",
    device = "spec:width=1280dp,height=800dp,dpi=480",
)
annotation class DevicePreviews

@Preview(
    name = "dark theme",
    group = "themes",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@FontScalePreviews
@DevicePreviews
annotation class CompletePreviews
