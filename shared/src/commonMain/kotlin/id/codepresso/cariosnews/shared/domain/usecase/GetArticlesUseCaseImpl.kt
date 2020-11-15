package id.codepresso.cariosnews.shared.domain.usecase

import id.codepresso.cariosnews.shared.data.entity.Article
import id.codepresso.cariosnews.shared.data.repository.ArticlesRepositoryImpl
import id.codepresso.cariosnews.shared.domain.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

class GetArticlesUseCaseImpl(
    private val articlesRepository: ArticlesRepositoryImpl
) : GetArticlesUseCase {

    override fun invoke(): Flow<Resource<List<Article>>> {
        return articlesRepository.getArticles().map {
            when (it.status) {
                Resource.Status.LOADING -> Resource.loading(null)
                Resource.Status.SUCCESS -> Resource.success(it.data)
                Resource.Status.ERROR -> Resource.error(it.error)
            }
        }
    }
}