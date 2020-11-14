package id.codepresso.cariosnews.shared.data.database

import com.squareup.sqldelight.db.SqlDriver

/**
 * Crafted by Razib Kani Maulidan on 14/11/20.
 **/

actual fun getDriver(dbName: String): SqlDriver = throw UninitializedPropertyAccessException("Android SqlDriver must be provided from main app")