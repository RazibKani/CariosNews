package id.codepresso.cariosnews.shared.data.service

import id.codepresso.cariosnews.shared.data.entity.Article
import id.codepresso.cariosnews.shared.domain.ApiResponse

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

interface ArticlesService {
    suspend fun getArticles(): ApiResponse<List<Article>>
}