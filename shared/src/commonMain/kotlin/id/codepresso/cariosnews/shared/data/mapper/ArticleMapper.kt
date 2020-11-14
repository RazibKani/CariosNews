package id.codepresso.cariosnews.shared.data.mapper

import id.codepresso.cariosnews.shared.data.entity.Article
import id.codepresso.cariosnews.shared.data.entity.ArticlesResponse

/**
 * Crafted by Razib Kani Maulidan on 14/11/20.
 **/

class ArticleMapper : Mapper<ArticlesResponse, List<Article>> {

    override fun transform(response: ArticlesResponse): List<Article> {
        return response.articles.map {
            Article(
                it.source.name,
                it.author,
                it.content,
                it.description,
                it.publishedAt,
                it.title,
                it.url,
                it.urlToImage
            )
        }
    }
}