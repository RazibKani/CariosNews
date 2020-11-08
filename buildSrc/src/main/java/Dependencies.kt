object Version {
    // Build
    const val androidGradle = "4.1.0"
    const val kotlin = "1.4.10"

    // Android

    // Native
    const val ktor = "1.4.1"
    const val kotlinxSerialization = "1.0.1"
    const val coroutines = "1.3.9-native-mt-2"
    const val sqldelight = "1.4.3"
}

object Dependency {
    // Build
    const val androidGradle = "com.android.tools.build:gradle:${Version.androidGradle}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Version.kotlin}"
    const val sqldelightGradle = "com.squareup.sqldelight:gradle-plugin:${Version.sqldelight}"

    // Android
    const val sqldelightAndroid = "com.squareup.sqldelight:android-driver:${Version.sqldelight}"
    const val ktorAndroid = "io.ktor:ktor-client-android:${Version.ktor}"

    // IOS
    const val sqldelightNative = "com.squareup.sqldelight:native-driver:${Version.sqldelight}"
    const val ktorIOS = "io.ktor:ktor-client-ios:${Version.ktor}"

    // Native
    const val kotlinxSerializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Version.kotlinxSerialization}"
    const val sqldelightRuntime = "com.squareup.sqldelight:runtime:${Version.sqldelight}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
    const val ktorCore = "io.ktor:ktor-client-core:${Version.ktor}"
    const val ktorJson = "io.ktor:ktor-client-json:${Version.ktor}"
    const val ktorSerialization = "io.ktor:ktor-client-serialization:${Version.ktor}"
}