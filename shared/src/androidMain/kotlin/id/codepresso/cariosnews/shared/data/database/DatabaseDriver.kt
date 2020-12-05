package id.codepresso.cariosnews.shared.data.database

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import id.codepresso.cariosnews.shared.sql.CariosNewsDatabase

/**
 * Crafted by Razib Kani Maulidan on 05/12/20.
 **/

actual object DatabaseDriver {
    lateinit var context: Context

    actual fun getDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = CariosNewsDatabase.Schema,
            context = context,
            name = "CariosNewsDb")
    }
}