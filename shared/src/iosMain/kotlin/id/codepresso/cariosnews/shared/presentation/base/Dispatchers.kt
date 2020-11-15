package id.codepresso.cariosnews.shared.presentation.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

actual val mainDispatcher: CoroutineDispatcher = Dispatchers.Main
actual val ioDispatcher: CoroutineDispatcher = Dispatchers.Main