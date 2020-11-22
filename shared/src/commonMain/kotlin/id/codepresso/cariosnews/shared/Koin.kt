package id.codepresso.cariosnews.shared

import id.codepresso.cariosnews.shared.data.database.ArticleDatabase
import id.codepresso.cariosnews.shared.data.database.Database
import id.codepresso.cariosnews.shared.data.database.DatabaseHelper
import id.codepresso.cariosnews.shared.data.entity.Article
import id.codepresso.cariosnews.shared.data.mapper.ArticleMapper
import id.codepresso.cariosnews.shared.data.repository.ArticlesRepositoryImpl
import id.codepresso.cariosnews.shared.data.service.ArticlesService
import id.codepresso.cariosnews.shared.data.service.ArticlesServiceImpl
import id.codepresso.cariosnews.shared.domain.repository.ArticlesRepository
import id.codepresso.cariosnews.shared.domain.usecase.GetArticlesUseCase
import id.codepresso.cariosnews.shared.presentation.feature.ListArticleViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

fun initKoin(appModule: Module): KoinApplication {
    val koinApplication = startKoin {
        modules(
            appModule,
            platformModule,
            sharedModule
        )
    }

    return koinApplication
}

private val sharedModule = module {
    // Database Instance
    single {
        DatabaseHelper(
            sqlDriver = get()
        )
    }

    // Article Database
    single<Database<Article>> {
        ArticleDatabase(
            dbHelper = get()
        )
    }

    // Services
    single<ArticlesService> {
        ArticlesServiceImpl(
            apiKey = "370e176e719747648cf38522ab15e7a8",
            baseUrl = "https://newsapi.org/v2/top-headlines",
            mapper = ArticleMapper()
        )
    }

    // Repository
    single<ArticlesRepository> {
        ArticlesRepositoryImpl(
            database = get(),
            service = get()
        )
    }

    // UseCase
    single {
        GetArticlesUseCase(
            articlesRepository = get()
        )
    }

    // ViewModel
    factory {
        ListArticleViewModel(
            getArticlesUseCase = get()
        )
    }
}

expect val platformModule: Module