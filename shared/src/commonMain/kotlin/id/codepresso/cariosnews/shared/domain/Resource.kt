package id.codepresso.cariosnews.shared.domain

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

data class Resource<out T>(
    val state: State,
    val data: T?,
    val error: Error?
) {

    enum class State {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(
                State.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(error: Error?, data: T? = null): Resource<T> {
            return Resource(
                State.ERROR,
                data,
                error
            )
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(
                State.LOADING,
                data,
                null
            )
        }
    }
}

data class Error(
    val code: Int,
    val message: String?
)