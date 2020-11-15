package id.codepresso.cariosnews.shared

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import id.codepresso.cariosnews.shared.sql.CariosNewsDatabase
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module

/**
 * Crafted by Razib Kani Maulidan on 15/11/20.
 **/

fun initKoinIos(doOnStartup: () -> Unit): KoinApplication = initKoin(
    module {
        single { doOnStartup }
    }
)

actual val platformModule = module {
    single<SqlDriver> {
        NativeSqliteDriver(
            schema = CariosNewsDatabase.Schema,
            name = "CariosNewsDb"
        )
    }
}

fun Koin.get(objCClass: ObjCClass, qualifier: Qualifier?, parameter: Any): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, qualifier) { parametersOf(parameter) }
}

fun Koin.get(objCClass: ObjCClass, parameter: Any): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, null) { parametersOf(parameter) }
}

fun Koin.get(objCClass: ObjCClass, qualifier: Qualifier?): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, qualifier, null)
}