package id.codepresso.cariosnews.shared.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

actual open class BaseViewModel actual constructor(): ViewModel() {

    actual val scope: CoroutineScope = viewModelScope

    actual override fun onCleared() {
        super.onCleared()
    }
}