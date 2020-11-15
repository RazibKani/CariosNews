package id.codepresso.cariosnews.shared.domain

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

sealed class ApiResponse<T>

/**
 * separate class for HTTP 204 responses so that we can make ApiSuccessResponse's body non-null.
 */
class ApiEmptyResponse<T> : ApiResponse<T>()

data class ApiSuccessResponse<T>(val body: T) : ApiResponse<T>()

data class ApiErrorResponse<T>(val statusCode: Int, val errorMessage: String) : ApiResponse<T>()