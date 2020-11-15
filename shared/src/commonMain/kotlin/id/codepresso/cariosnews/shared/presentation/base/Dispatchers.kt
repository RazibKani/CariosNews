package id.codepresso.cariosnews.shared.presentation.base

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

expect val mainDispatcher: CoroutineDispatcher
expect val ioDispatcher: CoroutineDispatcher