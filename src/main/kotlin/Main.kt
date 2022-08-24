data class Post(
    val id: Int,
    val owner_id: Int,
    val date: Int,
    val text: String,
    val reply_owner_id: Int,
    val friends_only: Boolean,
    val comments: Comments = Comments(),
    val copyright: String,
    val likes: Likes = Likes(),
    val views: Views = Views(),
    val post_type: String,
    val signer_id: Int,
    val can_pin: Boolean,
    val can_delete: Boolean,
    val can_edit: Boolean,
    val marked_as_ads: Boolean,
    val is_favorite: Boolean,
)
data class Likes(
    val count: Int = 15,
    val user_likes: Boolean = true,
    val can_publish: Boolean = true
)
data class Comments(
    var count: Int = 25,
    var can_post: Boolean = true,
)

data class Views(
    val count: Int = 1996
)
object WallService{
    private var posts = emptyArray<Post>()
    fun addPost(post: Post): Post{
        posts += post
        return posts.last()
    }
}
fun main(){
    val post = Post(1, 1, 2022, "Vk Post is ready!", 2, false, Comments(),
        "By me", Likes(15), Views(1996), "post", 1, can_pin = true, can_delete = false, false, true,
        is_favorite = true
    )
    println(WallService.addPost(post))
}