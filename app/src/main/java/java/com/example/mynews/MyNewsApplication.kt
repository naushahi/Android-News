package java.com.example.mynews

import android.app.Application
import java.com.example.mynews.data.AppContainer
import java.com.example.mynews.data.AppContainerImp

class MyNewsApplication: Application() {
    companion object {
        const val MY_NEWS_URL = "https://developer.android.com/jetnews"
    }

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImp(this)
    }
}