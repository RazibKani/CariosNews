package id.codepresso.cariosnews.android

import android.app.Application
import android.content.Context
import id.codepresso.cariosnews.shared.initKoin
import org.koin.dsl.module

/**
 * Crafted by Razib Kani Maulidan on 21/11/20.
 **/

class CariosNewsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            module {
                single<Context> { this@CariosNewsApp }
            }
        )
    }
}