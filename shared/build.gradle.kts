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
                implementation(Dependency.kotlinxSerializationCore)

                // Database
                implementation(Dependency.sqldelightRuntime)

                // Coroutines
                implementation(Dependency.coroutinesCore)

                // HTTP
                implementation(Dependency.ktorCore)
                implementation(Dependency.ktorJson)
                implementation(Dependency.ktorSerialization)

                // Koin
                implementation(Dependency.koinCore)
            }
        }
        val commonTest by getting

        val androidMain by getting {
            dependencies {
                // Database
                implementation(Dependency.sqldelightAndroid)

                // HTTP
                implementation(Dependency.ktorAndroid)

                // Lifecycle
                implementation(Dependency.lifecycleExtension)
                implementation(Dependency.lifecycleViewModelKtx)
            }
        }
        val androidTest by getting

        val iosMain by getting {
            dependencies {
                // Database
                implementation(Dependency.sqldelightNative)

                // HTTP
                implementation(Dependency.ktorIOS)

                // Koin
                implementation(Dependency.koinCore)
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