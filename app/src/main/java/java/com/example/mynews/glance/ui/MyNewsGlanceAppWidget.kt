package java.com.example.mynews.glance.ui

import android.content.Context
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.glance.ColorFilter
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.LocalContext
import androidx.glance.LocalSize
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.itemsIndexed
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.layout.width
import com.example.mynews.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.com.example.mynews.MyNewsApplication
import java.com.example.mynews.data.successOr
import java.com.example.mynews.glance.ui.theme.MyNewsGlanceColorScheme
import java.com.example.mynews.model.Post

class MyNewsGlanceAppWidget: GlanceAppWidget() {

    override val sizeMode: SizeMode = SizeMode.Exact

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val application = context.applicationContext as MyNewsApplication
        val postsRepository = application.container.postsRepository

        val initialPostsFeed = withContext(Dispatchers.IO) {
            postsRepository.getPostsFeed().successOr(null)
        }
        val initialBookmarks: Set<String> = withContext(Dispatchers.IO) {
            postsRepository.observeFavorites().first()
        }

        provideContent {
            val scope = rememberCoroutineScope()
            val bookmarks by postsRepository.observeFavorites().collectAsState(initialBookmarks)
            val postsFeed by postsRepository.observePostsFeed().collectAsState(initialPostsFeed)
            val recommendedTopPosts =
                postsFeed?.let {listOf(it.selectedPost) + it.recommendedPost} ?: emptyList()

            GlanceTheme (
                colors = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    GlanceTheme.colors
                } else {
                    MyNewsGlanceColorScheme.colors
                },
            ) {
                MyNewsContent(
                    posts = recommendedTopPosts,
                    bookmarks = bookmarks,
                    onToggleBookmark = {
                        scope.launch {
                            postsRepository.toggleFavorite(it)
                        }
                    }
                )
            }
        }
    }

    @Composable
    private fun MyNewsContent(posts: List<Post>, bookmarks: Set<String>?, onToggleBookmark: (String) -> Unit) {
        Column (
            modifier = GlanceModifier
                .background(GlanceTheme.colors.surface)
                .cornerRadius(24.dp),
        ){
            Header(modifier = GlanceModifier.fillMaxWidth())
            key (LocalSize.current) {
                Body(
                    modifier = GlanceModifier.fillMaxWidth(),
                    posts = posts,
                    bookmarks = bookmarks?:setOf(),
                    onToggleBookmark = onToggleBookmark,
                )
            }
        }
    }

    @Composable
    fun Header(modifier: GlanceModifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(horizontal = 10.dp, vertical = 20.dp),
        ){
            val context = LocalContext.current
            Image(
                provider = ImageProvider(R.drawable.ic_mynews_logo),
                colorFilter = ColorFilter.tint(GlanceTheme.colors.primary),
                contentDescription = null,
                modifier = GlanceModifier.size(24.dp),
            )
            Spacer(modifier = GlanceModifier.width(8.dp))
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }

    @Composable
    fun Body(modifier: GlanceModifier, posts: List<Post>, bookmarks: Set<String>?, onToggleBookmark: (String) -> Unit) {
        val postLayout = LocalSize.current.toPostLayout()
        LazyColumn (modifier = modifier.background(GlanceTheme.colors.background)) {
            itemsIndexed(posts) { index, post ->
                Column(modifier = GlanceModifier.padding(horizontal = 14.dp)) {
                    Post(
                        post = post,
                        bookmarks = bookmarks ?: emptySet(),
                        onToggleBookmark = onToggleBookmark,
                        modifier = GlanceModifier.padding(vertical = 15.dp),
                        postLayout = postLayout,
                    )
                    if(index < posts.lastIndex) {
                        Divider()
                    }
                }
            }
        }
    }
}