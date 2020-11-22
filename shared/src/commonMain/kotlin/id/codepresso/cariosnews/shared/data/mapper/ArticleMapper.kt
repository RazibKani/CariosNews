package id.codepresso.cariosnews.shared.data.mapper

import id.codepresso.cariosnews.shared.data.entity.Article
import id.codepresso.cariosnews.shared.domain.model.ArticlesResponse

/**
 * Crafted by Razib Kani Maulidan on 14/11/20.
 **/

class ArticleMapper : Mapper<ArticlesResponse, List<Article>> {

    override fun transform(response: ArticlesResponse): List<Article> {
        return response.articles.map { articleResponse ->
            Article(
                source = articleResponse.source.name,
                author = articleResponse.author,
                content = articleResponse.content,
                description = articleResponse.description,
                publishedAt = articleResponse.publishedAt,
                title = articleResponse.title,
                url = articleResponse.url,
                urlToImage = articleResponse.urlToImage
            )
        }
    }
}