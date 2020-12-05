package id.codepresso.cariosnews.shared.data.database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import id.codepresso.cariosnews.shared.sql.CariosNewsDatabase

/**
 * Crafted by Razib Kani Maulidan on 05/12/20.
 **/

actual object DatabaseDriver {
    actual fun getDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = CariosNewsDatabase.Schema,
            name = "CariosNewsDb"
        )
    }
}