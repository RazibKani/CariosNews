package id.codepresso.cariosnews.shared.data.mapper

/**
 * Crafted by Razib Kani Maulidan on 14/11/20.
 **/

interface Mapper<in T, out E> {
    fun transform(response: T): E
}