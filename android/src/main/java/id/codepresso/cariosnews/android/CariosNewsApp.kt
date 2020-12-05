package id.codepresso.cariosnews.android

import android.app.Application
import id.codepresso.cariosnews.shared.data.database.DatabaseDriver.context

/**
 * Crafted by Razib Kani Maulidan on 21/11/20.
 **/

class CariosNewsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }
}