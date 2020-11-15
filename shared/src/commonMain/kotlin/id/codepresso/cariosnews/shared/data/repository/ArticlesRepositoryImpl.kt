package id.codepresso.cariosnews.shared.data.repository

import id.codepresso.cariosnews.shared.data.database.Database
import id.codepresso.cariosnews.shared.data.entity.Article
import id.codepresso.cariosnews.shared.data.service.ArticlesServices
import id.codepresso.cariosnews.shared.domain.Resource
import id.codepresso.cariosnews.shared.domain.repository.ArticlesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

class ArticlesRepositoryImpl(
    private val service: ArticlesServices,
    private val database: Database<Article>
) : ArticlesRepository {

    override fun getArticles(): Flow<Resource<List<Article>>> {
        return flow {
            emit(Resource.loading())

            val cachedArticles = database.selectAll()

            if (cachedArticles.isNotEmpty()) {
                emit(Resource.success(cachedArticles))
            } else {
                val serviceResource = service.getArticles()
                emit(serviceResource)

                serviceResource.data?.let { articles ->
                    database.clear()
                    database.insertAll(articles)
                }
            }
        }
    }

}