package id.codepresso.cariosnews.shared

import id.codepresso.cariosnews.shared.data.database.ArticleDatabase
import id.codepresso.cariosnews.shared.data.database.DatabaseDriver
import id.codepresso.cariosnews.shared.data.database.DatabaseHelper
import id.codepresso.cariosnews.shared.data.mapper.ArticleMapper
import id.codepresso.cariosnews.shared.data.repository.ArticlesRepositoryImpl
import id.codepresso.cariosnews.shared.data.service.ArticlesServiceImpl
import id.codepresso.cariosnews.shared.domain.usecase.GetArticlesUseCase
import id.codepresso.cariosnews.shared.presentation.feature.ListArticleViewModel
import kotlin.native.concurrent.ThreadLocal

/**
 * Crafted by Razib Kani Maulidan on 05/12/20.
 **/

@ThreadLocal
object ServiceLocator {

    private val databaseHelper = DatabaseHelper(sqlDriver = DatabaseDriver.getDriver())

    // Article Database
    private val articleDatabase = ArticleDatabase(dbHelper = databaseHelper)

    // Services
    private val articleService = ArticlesServiceImpl(
        apiKey = "370e176e719747648cf38522ab15e7a8",
        baseUrl = "https://newsapi.org/v2/top-headlines",
        mapper = ArticleMapper()
    )

    // Repository
    private val articleRepository = ArticlesRepositoryImpl(
        database = articleDatabase,
        service = articleService
    )

    // UseCase
    private val getArticleUseCase = GetArticlesUseCase(
        articlesRepository = articleRepository
    )

    // ViewModel
    val listArticleViewModel = ListArticleViewModel(
        getArticlesUseCase = getArticleUseCase
    )
}