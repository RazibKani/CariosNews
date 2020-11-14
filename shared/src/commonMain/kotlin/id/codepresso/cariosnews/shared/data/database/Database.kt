package id.codepresso.cariosnews.shared.data.database

/**
 * Crafted by Razib Kani Maulidan on 14/11/20.
 **/

interface Database<ENTITY> {
    fun insert(model: ENTITY)
    fun insertAll(listModel: List<ENTITY>)
    fun selectAll(): List<ENTITY>
    fun clear()
}