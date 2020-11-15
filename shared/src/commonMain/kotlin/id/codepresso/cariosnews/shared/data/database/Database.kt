package id.codepresso.cariosnews.shared.data.database

/**
 * Crafted by Razib Kani Maulidan on 14/11/20.
 **/

interface Database<T> {
    fun insert(model: T)
    fun insertAll(listModel: List<T>)
    fun selectAll(): List<T>
    fun clear()
}