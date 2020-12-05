package id.codepresso.cariosnews.shared.data.database

import com.squareup.sqldelight.db.SqlDriver

/**
 * Crafted by Razib Kani Maulidan on 05/12/20.
 **/

expect object DatabaseDriver {
    fun getDriver(): SqlDriver
}