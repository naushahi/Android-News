package java.com.example.mynews.data.posts

import kotlinx.coroutines.flow.Flow
import java.com.example.mynews.data.Result
import java.com.example.mynews.model.Post
import java.com.example.mynews.model.PostFeed

interface PostsRepository {
    suspend fun getPost(postId: String?): Result<Post>
    suspend fun getPostsFeed(): Result<PostFeed>
    fun observeFavorites(): Flow<Set<String>>
    fun observePostsFeed(): Flow<PostFeed?>
    suspend fun toggleFavorite(postId: String)
}