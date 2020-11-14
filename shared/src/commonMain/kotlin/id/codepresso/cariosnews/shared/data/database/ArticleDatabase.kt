package id.codepresso.cariosnews.shared.data.database

import id.codepresso.cariosnews.shared.data.entity.Article

/**
 * Crafted by Razib Kani Maulidan on 14/11/20.
 **/

class ArticleDatabase(private val dbHelper: DatabaseHelper) : Database<Article> {

    override fun insert(model: Article) {
        dbHelper.database.articleQueries.insert(
            model.source,
            model.author,
            model.content,
            model.description,
            model.publishedAt,
            model.title,
            model.url,
            model.urlToImage
        )
    }

    override fun insertAll(listModel: List<Article>) {
        dbHelper.database.transaction {
            listModel.forEach { article ->
                insert(article)
            }
        }
    }

    override fun selectAll(): List<Article> {
        val articles = dbHelper.database.articleQueries.selectAll().executeAsList()

        return articles.map {
            Article(
                it.source,
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

    override fun clear() {
        dbHelper.database.articleQueries.deleteAll()
    }

}