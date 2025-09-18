package java.com.example.mynews.glance

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import java.com.example.mynews.glance.ui.MyNewsGlanceAppWidget

class MyNewsGlanceAppWidgetReceiver: GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = MyNewsGlanceAppWidget()
}