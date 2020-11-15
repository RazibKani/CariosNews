package id.codepresso.cariosnews.shared

import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import id.codepresso.cariosnews.shared.sql.CariosNewsDatabase
import org.koin.dsl.module

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

actual val platformModule = module {
    single<SqlDriver> {
        AndroidSqliteDriver(
            schema = CariosNewsDatabase.Schema,
            context = get(),
            "CariosNewsDb"
        )
    }
}