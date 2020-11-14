package id.codepresso.cariosnews.shared.data.database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import id.codepresso.cariosnews.shared.sql.CariosNewsDatabase

/**
 * Crafted by Razib Kani Maulidan on 14/11/20.
 **/

actual fun getDriver(dbName: String): SqlDriver {
    return NativeSqliteDriver(CariosNewsDatabase.Schema, dbName)
}