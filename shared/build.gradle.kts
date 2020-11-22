plugins {
    kotlin("multiplatform")
    id("kotlinx-serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

group = "id.codepresso.cariosnews"
version = AppVersion.name

android {
    compileSdkVersion(AndroidSDKVersion.compile)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(AndroidSDKVersion.minimum)
        targetSdkVersion(AndroidSDKVersion.target)
        versionCode = AppVersion.code
        versionName = AppVersion.name
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
    }
}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }

    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
    if (onPhone) {
        iosArm64("ios")
    } else {
        iosX64("ios")
    }

    sourceSets {
        all {
            languageSettings.apply {
                useExperimentalAnnotation("kotlin.RequiresOptIn")
                useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Deps.kotlinxSerializationCore)

                // Database
                implementation(Deps.SqlDelight.runtime)

                // Coroutines
                implementation(Deps.Coroutines.core) {
                    version {
                        strictly(Versions.coroutines)
                    }
                }

                // HTTP
                implementation(Deps.Ktor.core)
                implementation(Deps.Ktor.json)
                implementation(Deps.Ktor.serialization)

                // Koin
                implementation(Deps.Koin.core)
            }
        }
        val commonTest by getting

        val androidMain by getting {
            dependencies {
                implementation(kotlin("stdlib", Versions.kotlin))

                // Database
                implementation(Deps.SqlDelight.android)

                // HTTP
                implementation(Deps.Ktor.android)

                // Lifecycle
                implementation(Deps.AndroidX.lifecycleExtension)
                implementation(Deps.AndroidX.lifecycleViewModelKtx)
            }
        }
        val androidTest by getting

        val iosMain by getting {
            dependencies {
                // Database
                implementation(Deps.SqlDelight.native)

                // HTTP
                implementation(Deps.Ktor.ios)
            }
        }
        val iosTest by getting
    }
}

sqldelight {
    database("CariosNewsDatabase") {
        packageName = "id.codepresso.cariosnews.shared.sql"
        sourceFolders = listOf("sqldelight")
    }
}