package id.codepresso.cariosnews.shared.domain.usecase

import id.codepresso.cariosnews.shared.domain.repository.ArticlesRepository

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

class GetArticlesUseCase(private val articlesRepository: ArticlesRepository) {
    operator fun invoke() = articlesRepository.getArticles()
}