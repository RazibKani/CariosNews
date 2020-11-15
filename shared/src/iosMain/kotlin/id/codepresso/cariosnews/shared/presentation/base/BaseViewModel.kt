package id.codepresso.cariosnews.shared.presentation.base

import kotlinx.coroutines.CoroutineScope

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

actual open class BaseViewModel actual constructor() {

    actual val scope: CoroutineScope = CoroutineScope(Ios)

    protected actual open fun onCleared() {
    }

}