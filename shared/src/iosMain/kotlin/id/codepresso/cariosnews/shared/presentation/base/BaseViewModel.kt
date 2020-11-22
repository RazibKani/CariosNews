package id.codepresso.cariosnews.shared.presentation.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

actual open class BaseViewModel actual constructor() {

    private val viewModelJob = SupervisorJob()

    actual val scope: CoroutineScope = CoroutineScope(ioDispatcher + viewModelJob)

    protected actual open fun onCleared() {
        viewModelJob.cancelChildren()
    }

}