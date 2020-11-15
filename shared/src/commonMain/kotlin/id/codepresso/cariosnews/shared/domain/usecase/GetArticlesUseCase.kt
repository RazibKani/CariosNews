package id.codepresso.cariosnews.shared.domain.usecase

import id.codepresso.cariosnews.shared.data.repository.ArticlesRepositoryImpl

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

class GetArticlesUseCase(private val articlesRepository: ArticlesRepositoryImpl) {
    operator fun invoke() = articlesRepository.getArticles()
}