package java.com.example.mynews.model

data class PostFeed (
    val selectedPost: Post,
    val recommendedPost: List<Post>,
    val popularPosts: List<Post>,
    val recentPosts: List<Post>,
) {
    val allPosts: List<Post> =
        listOf(selectedPost) + recommendedPost + popularPosts + recentPosts
}