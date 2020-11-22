package id.codepresso.cariosnews.shared.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Crafted by Razib Kani Maulidan on 14/11/20.
 **/

@Serializable
data class ArticlesResponse(
    @SerialName("articles")
    val articles: List<ArticleResponse>)

@Serializable
data class ArticleResponse(
    @SerialName("source") val source: SourceResponse,
    @SerialName("author") val author: String?,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("url") val url: String,
    @SerialName("urlToImage") val urlToImage: String,
    @SerialName("publishedAt") val publishedAt: String,
    @SerialName("content") val content: String?
)

@Serializable
data class SourceResponse(
    @SerialName("name")
    val name: String
)