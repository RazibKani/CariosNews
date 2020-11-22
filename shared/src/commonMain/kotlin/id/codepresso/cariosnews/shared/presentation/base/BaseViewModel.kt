package id.codepresso.cariosnews.shared.presentation.base

import kotlinx.coroutines.CoroutineScope

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

expect open class BaseViewModel() {
    val scope: CoroutineScope
    protected open fun onCleared()
}