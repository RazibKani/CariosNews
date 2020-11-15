package id.codepresso.cariosnews.shared

import id.codepresso.cariosnews.shared.data.database.DatabaseHelper
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
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
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

    // Dummy initialization logic, making use of appModule declarations for demonstration purposes.
    val koin = koinApplication.koin
    val doOnStartup = koin.get<() -> Unit>() // doOnStartup is a lambda which is implemented in Swift on iOS side
    doOnStartup.invoke()

    return koinApplication
}

private val sharedModule = module {
    // Database
    single {
        DatabaseHelper(
            sqlDriver = getWith("DatabaseHelper")
        )
    }

    // Services
    single<ArticlesService> {
        ArticlesServiceImpl(
            apiKey = "370e176e719747648cf38522ab15e7a8",
            baseUrl = "",
            mapper = get()
        )
    }

    // Mapper
    single {
        ArticleMapper()
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

internal inline fun <reified T> Scope.getWith(vararg params: Any?): T {
    return get(parameters = { parametersOf(*params) })
}

expect val platformModule: Module