package java.com.example.mynews.data

import android.content.Context
import java.com.example.mynews.data.intrests.InterestsRepository
import java.com.example.mynews.data.intrests.impl.FakeInterestsRepository
import java.com.example.mynews.data.posts.PostsRepository
import java.com.example.mynews.data.posts.impl.FakePostsRepository

interface AppContainer {

    val postsRepository: PostsRepository
    val interestsRepository: InterestsRepository
}

class AppContainerImp(private val applicationContext: Context) : AppContainer {
    override val interestsRepository: InterestsRepository by lazy {
        FakeInterestsRepository()
    }
    override val postsRepository: PostsRepository by lazy {
        FakePostsRepository()
    }
}