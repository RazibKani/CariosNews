package id.codepresso.cariosnews.shared.presentation.feature

import id.codepresso.cariosnews.shared.domain.usecase.GetArticlesUseCase
import id.codepresso.cariosnews.shared.presentation.base.BaseViewModel
import id.codepresso.cariosnews.shared.presentation.util.asCommonFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

@ExperimentalCoroutinesApi
class ListArticleViewModel(getArticlesUseCase: GetArticlesUseCase) : BaseViewModel() {

    var articlesResource
            = getArticlesUseCase.invoke().asCommonFlow()

}