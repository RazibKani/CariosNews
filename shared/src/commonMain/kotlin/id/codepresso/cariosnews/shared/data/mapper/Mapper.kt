package id.codepresso.cariosnews.shared.data.mapper

/**
 * Crafted by Razib Kani Maulidan on 14/11/20.
 **/

interface Mapper<in RESPONSE, out ENTITY> {
    fun transform(response: RESPONSE): ENTITY
}