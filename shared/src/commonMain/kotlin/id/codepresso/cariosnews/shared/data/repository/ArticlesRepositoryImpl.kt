package id.codepresso.cariosnews.shared.data.repository

import id.codepresso.cariosnews.shared.data.database.Database
import id.codepresso.cariosnews.shared.data.entity.Article
import id.codepresso.cariosnews.shared.data.service.ArticlesService
import id.codepresso.cariosnews.shared.domain.*
import id.codepresso.cariosnews.shared.domain.repository.ArticlesRepository
import id.codepresso.cariosnews.shared.presentation.base.ioDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

class ArticlesRepositoryImpl(
    private val service: ArticlesService,
    private val database: Database<Article>
) : ArticlesRepository {

    override fun getArticles(): Flow<Resource<List<Article>>> {
        return flow {
            emit(Resource.loading())
            val cachedArticles = database.selectAll()

            if (cachedArticles.isNotEmpty()) {
                emit(Resource.success(cachedArticles))
            } else {
                val response = service.getArticles()
                when (response) {
                    is ApiSuccessResponse -> {
                        emit(Resource.success(response.body))
                    }
                    is ApiEmptyResponse -> {
                        emit(Resource.success(null))
                    }
                    is ApiErrorResponse -> {
                        val error = Error(response.statusCode, response.errorMessage)
                        emit(Resource.error(null, error))
                    }
                }
            }
        }.flowOn(ioDispatcher)
    }

}