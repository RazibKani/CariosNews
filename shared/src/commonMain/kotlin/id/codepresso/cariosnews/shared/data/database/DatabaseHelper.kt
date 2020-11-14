package id.codepresso.cariosnews.shared.data.database

import com.squareup.sqldelight.db.SqlDriver
import id.codepresso.cariosnews.shared.sql.CariosNewsDatabase

/**
 * Crafted by Razib Kani Maulidan on 14/11/20.
 **/

expect fun getDriver(dbName: String): SqlDriver

class DatabaseHelper(
    dbName: String,
    sqlDriver: SqlDriver) {

    val driver = sqlDriver ?: getDriver(dbName)
    val database = CariosNewsDatabase(driver)
}