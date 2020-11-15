package id.codepresso.cariosnews.shared.domain.repository

import id.codepresso.cariosnews.shared.data.entity.Article
import id.codepresso.cariosnews.shared.domain.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

interface ArticlesRepository {
    
    fun getArticles(): Flow<Resource<List<Article>>>

}