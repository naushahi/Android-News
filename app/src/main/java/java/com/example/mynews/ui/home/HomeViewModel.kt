package java.com.example.mynews.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.mynews.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.com.example.mynews.data.Result
import java.com.example.mynews.data.posts.PostsRepository
import java.com.example.mynews.model.Post
import java.com.example.mynews.model.PostFeed
import java.com.example.mynews.utils.ErrorMessage
import java.util.UUID

sealed interface HomeUiState {
    val isLoading: Boolean
    val errorMessages: List<ErrorMessage>
    val searchInput: String

    data class NoPosts(override val isLoading: Boolean,override val errorMessages: List<ErrorMessage>,override val searchInput: String):
    HomeUiState

    data class HasPosts(
        val postsFeed: PostFeed,
        val selectedPost: Post,
        val isArticleOpen: Boolean,
        val favorites: Set<String>,
        override val isLoading: Boolean,
        override val errorMessages: List<ErrorMessage>,
        override val searchInput: String,
    ): HomeUiState
}

private data class HomeViewModelState(
    val postsFeed: PostFeed? = null,
    val selectedPostId: String? = null,
    val isArticleOpen: Boolean = false,
    val favorites: Set<String> = emptySet(),
    val isLoading: Boolean = false,
    val errorMessages: List<ErrorMessage> = emptyList(),
    val searchInput: String = ""
) {
    fun toUiState(): HomeUiState = if(postsFeed == null) {
        HomeUiState.NoPosts(
            isLoading = isLoading,
            errorMessages = errorMessages,
            searchInput = searchInput,
        )
    } else {
            HomeUiState.HasPosts(
                postsFeed = postsFeed,
                selectedPost = postsFeed.allPosts.find {
                    it.id == selectedPostId
                } ?: postsFeed.selectedPost,
                isArticleOpen = isArticleOpen,
                favorites = favorites,
                isLoading = isLoading,
                errorMessages = errorMessages,
                searchInput = searchInput,
            )
        }
    }

class HomeViewModel(private val postsRepository: PostsRepository, preselectedPost: String?) : ViewModel() {
    private val viewModelState = MutableStateFlow(
        HomeViewModelState(
            isLoading = true,
            selectedPostId = preselectedPost,
            isArticleOpen = preselectedPost != null,
        )
    )

    val uiState = viewModelState
        .map(HomeViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        refreshPosts()
        viewModelScope.launch {
            postsRepository.observeFavorites().collect { favorites ->
                viewModelState.update { it.copy(favorites = favorites) }
            }
        }
    }

    fun refreshPosts() {
        viewModelState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val result = postsRepository.getPostsFeed()
            viewModelState.update {
                when(result) {
                    is Result.Success -> it.copy(postsFeed = result.data, isLoading = false)
                    is java.com.example.mynews.data.Result.Error -> {
                        val errorMessages = it.errorMessages + ErrorMessage(
                            id = UUID.randomUUID().mostSignificantBits,
                            messageId = R.string.load_error
                        )
                        it.copy(errorMessages = errorMessages, isLoading = false)
                    }

                }
            }

        }
    }

    fun toggleFavorite(postId: String) {
        viewModelScope.launch {
            postsRepository.toggleFavorite(postId)
        }
    }

    fun selectArticle(postId: String) {
        interactedWithArticleDetails(postId)
    }

    fun errorShown(errorId: Long) {
        viewModelState.update { currentUiState ->
            val errorMessages = currentUiState.errorMessages.filterNot { it.id == errorId }
            currentUiState.copy(errorMessages = errorMessages)
        }

    }

    fun interactedWithFeed() {
        viewModelState.update {
            it.copy(isArticleOpen = false)
        }
    }

    fun interactedWithArticleDetails(postId: String) {
        viewModelState.update {
            it.copy(
                selectedPostId = postId,
                isArticleOpen = true
            )
        }

    }

    fun onSearchInputChanged(searchInput: String) {
        viewModelState.update {
            it.copy(searchInput = searchInput)
        }
    }

    companion object {
        fun provideFactory(postsRepository: PostsRepository, preSelectedPostId: String? = null): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return HomeViewModel(postsRepository, preSelectedPostId) as T
                }
            }
    }
}