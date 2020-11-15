package id.codepresso.cariosnews.shared.domain

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val error: Error?
) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(error: Error?, data: T? = null): Resource<T> {
            return Resource(
                Status.ERROR,
                data,
                error
            )
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(
                Status.LOADING,
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