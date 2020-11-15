package id.codepresso.cariosnews.shared.data.database

import com.squareup.sqldelight.db.SqlDriver
import id.codepresso.cariosnews.shared.sql.CariosNewsDatabase

/**
 * Crafted by Razib Kani Maulidan on 14/11/20.
 **/

class DatabaseHelper(sqlDriver: SqlDriver) {
    val database = CariosNewsDatabase(sqlDriver)
}