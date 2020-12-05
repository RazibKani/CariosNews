package id.codepresso.cariosnews.shared.domain

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

data class Resource<out T>(val state: UIState, val data: T?, val error: Error? = null) {
    companion object {
        fun <T> loading(data: T? = null): Resource<T> = Resource(UIState.Loading, data)
        fun <T> success(data: T?): Resource<T> = Resource(UIState.Success, data)
        fun <T> error(data: T? = null, error: Error): Resource<T> = Resource(UIState.Error, data, error)
    }
}

data class Error(val code: Int, val message: String)

sealed class UIState {
    object Loading : UIState()
    object Success : UIState()
    object Error : UIState()
}