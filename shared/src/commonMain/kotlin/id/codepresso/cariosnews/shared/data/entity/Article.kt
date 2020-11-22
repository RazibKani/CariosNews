package id.codepresso.cariosnews.shared.data.entity

/**
 * Crafted by Razib Kani Maulidan on 14/11/20.
 **/

data class Article(
    val source: String,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String?
)