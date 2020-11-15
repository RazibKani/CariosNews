package id.codepresso.cariosnews.shared.domain.usecase

import id.codepresso.cariosnews.shared.data.entity.Article
import id.codepresso.cariosnews.shared.domain.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

interface GetArticlesUseCase {
    operator fun invoke(): Flow<Resource<List<Article>>>
}